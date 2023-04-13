package controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
//controllers 패키지 포함 모든 하위 패키지, 클래스 적용
//controller의 공통기능
public class CommonController {
    /**
    @ExceptionHandler(RuntimeException.class)
    public String errorHandler(RuntimeException e, Model model){

        e.printStackTrace();
        model.addAttribute("message", e.getMessage());

        return "errors/common";
    }
    */

}
