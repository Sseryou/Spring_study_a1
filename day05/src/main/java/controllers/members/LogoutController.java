package controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션을 비움으로써 로그아웃을 구현해 준다.

        return "redirect:/member/login";
    }

}
