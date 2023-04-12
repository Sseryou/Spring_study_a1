package controllers.members;


import lombok.RequiredArgsConstructor;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginValidator validator;

    private final LoginService service;

    @GetMapping
    public String login(Model model){
        //커맨드 객체가 비어있다 하더라도 무언가를 넣어줘야 한다.
        //문제 발생할 수 있음. 보통 model을 넣는다.
        Login login = new Login();
        model.addAttribute("login", login);
        return "member/login";
    }

    @PostMapping
    public String loginPs(@Valid Login login, Errors errors){
        //@Valid = 검증 기능의 애노테이션 . 꼭 기억하기!
        //검증실패시, 바로 앞의 errors로 값을 넘긴다.
        validator.validate(login, errors);

        if(errors.hasErrors()){
            return "member/login";
        }
        //로그인 처리.
        service.login(login);



        return "redirect:/"; //로그인 성공시, 메인페이지로 이동
    }

}
