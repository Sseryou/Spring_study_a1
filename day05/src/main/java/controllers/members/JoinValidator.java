package controllers.members;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component //@ComponentScan에 포함되도록 설정하는 애노테이션
@RequiredArgsConstructor
public class JoinValidator implements Validator {
    //Join 커맨드 객체를 검증하기 위한 클래스
    //validator 단위에서의 검증도 필요하다.

    //기본 생성자가 없는 상태에서 final을 붙이고,
    //@RequiredArgsConstructor를 클래스에 붙여주는 것으로 의존성 주입이 가능해진다.
    //@Autowired를 쓰지 않는 방식.
    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        //정해진 패턴 : Join 커맨드 객체로 검증을 한정
        return Join.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //커맨드 객체를 다양한 형태로 받기 위해 Object 사용
        Join join = (Join)target;

        /**
         * 1. 필수 항목 체크 - userId, userPw, userPwRe, userNm
         * 2. userId 중복 여부 - 이미 가입된 경우는 가입 불가
         * 3. userPw, userPwRe의 일치 여부
         * 4. 약관 동의 여부
         */

        String userId = join.getUserId();
        String userPw = join.getUserPw();
        String userPwRe = join.getUserPwRe();

        // 2. userId 중복 여부 - 이미 가입된 경우는 가입 불가
        if(userId != null && !userId.isBlank() && memberDao.isExist(userId)){
            errors.rejectValue("userId", "Duplicated");
        }

        //3. userPw, userPwRe의 일치 여부
        if(userPw != null && !userPw.isBlank()
                && userPwRe != null && !userPwRe.isBlank()
                && !userPw.equals(userPwRe)){
            errors.rejectValue("userPwRe", "Incorrect");
        }

        //공통 에러 테스트
        //errors.reject("common", "공통 에러 테스트!");


        //1. 필수 항목 체크
        /**
        if(userId == null || userId.isBlank()){
            //해당하는 메세지가 없을 경우, 3번째에 있는 기본 메세지 출력
            //errors.rejectValue("userId", "Required2", "아이디 입력(기본)");
            errors.rejectValue("userId", "Required" );
        }

        if(userPw == null || userPw.isBlank()){
            errors.rejectValue("userPw", "Required");
        }

        if(userPwRe == null || userPwRe.isBlank()){
            errors.rejectValue("userPwRe", "Required");
        }

        if(userNm == null || userNm.isBlank()){
            errors.rejectValue("userNm", "Required");
        }
        */

        /** 이것도 불편하다 하다...더 편한방법....
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPwRe", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm", "Required");
        */
    }
}
