package models.member;

import config.ManualBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ManualBean
public class MemberDao {
    //메모리 기반으로 DB 구현
    private static Map<String, Member> members = new HashMap<>();

    //회원 가입
    public void insert(Member member){
        member.setRegDt(LocalDateTime.now());
        members.put(member.getUserId(), member);
    }

    public Member get(String userId){
        return members.get(userId);
    }


    public List<Member> gets(){
        List<Member> list = new ArrayList<>(members.values());
        return list;
    }

}
