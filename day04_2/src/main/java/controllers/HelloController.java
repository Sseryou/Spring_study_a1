package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //요청을 처리할수 있는 특수한 목적의 관리객체
public class HelloController {
    //어떤 요청을 처리할 것인가? 알려줘야함.

    //hello에 들어온 GET방식의 요청을 처리하는 매핑
    @GetMapping("/hello")
    public String hello(){

        return "hello"; // /WEB-INF/view/hello.jsp
    }

}
