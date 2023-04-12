package controllers.members;


import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    //메서드 오버라이드.
    @Autowired //의존성 주입
    private MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        //로그인 커맨드객체 검증
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login = (Login)target;

        String userId = login.getUserId();
        String userPw = login.getUserPw();
        //1. 아이디로 회원이 조회 되는지
        Member member = null;
        if(userId != null && !userId.isBlank()){
            member = memberDao.get(userId);
            System.out.println(member);
            if(member == null){
                errors.rejectValue("userId", "MemberNotExist", "등록되지 않은 회원입니다.");
            }
        }

        //2. 회원이 있다면 -> 비밀번호 검증

        if(member != null && userPw != null && !userPw.isBlank()){
            String hash = member.getUserPw();
            boolean isMatched = BCrypt.checkpw(userPw, hash);
            if(!isMatched){
                //아이디와 비밀번호 중 무엇이 일치하지 알려주지 않는것은 좋지 않다.
                //아이디 때려맞추고 비밀번호 맞추는 경우 생각....
                errors.rejectValue("userPw", "IncorrectPw", "비밀번호가 일치하지 않습니다.");
            }
        }



    }
}
