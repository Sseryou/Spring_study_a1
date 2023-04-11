package controllers.members;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MembersController {

    @GetMapping("/members")
    public String members(Model model){

        /*멤버 10개를 반복문으로 생성해서 넣는 함수*/
        List<Member> members = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            Member member = new Member();
            member.setUserId("user" + i);
            member.setUserNm("사용자" + i);
            member.setMobile("010-0000-0000");
            member.setRegDt(LocalDateTime.now());
            members.add(member);
        }
        model.addAttribute("members", members);
        model.addAttribute("param1", "v1");
        model.addAttribute("param2", "v2");
        return "member/members";
    }


}
