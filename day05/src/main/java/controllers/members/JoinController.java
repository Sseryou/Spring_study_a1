package controllers.members;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member/join")
@RequiredArgsConstructor //final, @NonNull 이 있는 멤버 변수 초기화 생성자
public class JoinController {


    //RequiredArgsConstructor로 인한 의존성 주입 상태
    //final 붙이기 또는 @NonNull 붙이기
    private final JoinValidator validator;

    private final JoinService service;



    @GetMapping // /member/join
    public String join(Model model) {

        Join join = new Join();
        model.addAttribute("join", join);
        return "member/join";
    }

    @PostMapping // /member/join
    //커맨드 객체에 @Valid가 필요, 에러 사항에 걸리면 errors로 값 전달
    //커맨드 객체 바로앞에 Error가 있어야 함! 커맨드 진행방향이 좌에서 우기 때문에..
    public String joinPs(@Valid Join join, Errors errors, Model model) {

        validator.validate(join, errors);
        //이 순간에, validator를 검증하기 위한 추가 클래스가 필요해 진다.
        //joinValidator
        if(errors.hasErrors()){
            //에러가 있으면 처리 X -> 양식
            return "member/join";
        }

        //회원 가입 처리
        service.join(join);


        //model.addAttribute("join", join);
        System.out.println(join);
        //성공시에는 회원 로그인...
        return "redirect:/member/login";
    }
}
