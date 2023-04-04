package models.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    //멤버를 조회하거나 조작하는 기능을 전담하도록 만든 객체
    //다만, 지금은 데이터베이스와의 연계를 하지 않고,
    //HashMap을 이용하여 방식만 비슷하게 간략하게 구현을 하였다.(key,value방식)
    private static Map<String, Member> members = new HashMap<>();

    //멤버의 정보를 members에 주입하는 메서드이다.
    //다만 지금은 멤버를 만들때, 멤버 아이디를 키로 받고, 값으로 멤버 만들때 작성한 모든 정보를 넣는다.
    public void insert(Member member){
        members.put(member.getUserId(), member);
    }

    //userId를 값으로 받아서, 그 userId에 해당하는 멤버를 불러 올 수 있는 메서드이다.
    //간략하게 말하자면, 멤버를 조회하는 메서드이다.
    public Member get(String userId){
        return members.get(userId);
    }

}
