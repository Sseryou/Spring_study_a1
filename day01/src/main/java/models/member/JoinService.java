package models.member;


public class JoinService {
    private MemberDao memberDao;

    public JoinService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public void join(Member member){
        memberDao.insert(member);
    }

}
