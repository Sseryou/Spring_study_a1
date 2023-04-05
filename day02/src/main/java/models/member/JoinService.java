package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    private MemberDao memberDao;

    //@Qualifier("mDao1")로 연결된 객체를 주입받는다.


    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao= memberDao;
    }

    public void join(Member member){
        memberDao.insert(member);
    }

}
