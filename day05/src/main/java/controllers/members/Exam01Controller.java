package controllers.members;

import models.member.Member;
import models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Exam01Controller {
    @Autowired
    private MemberDao memberDao;


    //바뀔수 있는 변수는 중괄호로 감싸야 한다.
    @GetMapping("/member2/{id}")
    //원래 @GetMapping과 @PathVariable 통해 데이터를 넘겨주려면 동일한 명칭이어야 한다.그리고 필수로 값이 있어야 된다.
    //현재 상태는 id에서 받아온 정보를 @PathVariable를 통해 userId로 넘겨준다.
    //false로 필수값 설정을 해제할 수 있다.
    public String memberInfo(@PathVariable(name="id",required = false) String userId, Model model){
        System.out.printf("userId = %s", userId);

        Member member = memberDao.get(userId);
        model.addAttribute("member2", member);

        return "member/info2";
    }


}
