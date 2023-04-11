package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    /**
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false) String nm, boolean agree, Model model) {
        System.out.printf("name=%s, agree=%s%n", nm, agree);
        model.addAttribute("message", "안녕하세요!");

        return "hello"; // String, ModelAndView
    }
    */
    @GetMapping("/hello")
    public ModelAndView hello(String name, String agree) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "안녕하세요.");
        mv.addObject("name", name);

        mv.setViewName("hello");
        return mv;
    }

}
