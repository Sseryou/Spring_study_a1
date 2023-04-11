package controllers.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        /* 둘 중 어느 방식을 사용해도 된다고 하신다. 지금은 둘 다 보여주기 위해서 둘다 사용*/
        /* 많이 반복되는 것은 제거. 지금은 확장자명이 반복되니 제거 */
        String[] addCss = {"board/form", "board/fileupload"};
        List<String> addScript = Arrays.asList("board/form", "board/fileupload");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);

        model.addAttribute("pageTitle", "메인페이지!");

        return "main/index";
    }

}
