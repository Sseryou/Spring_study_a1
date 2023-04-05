package models.member;


public class JoinService {
    //회원 가입 시스템을 관리하기 위한 클래스이다.
    //DAO(Data Access Object) : DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체
    //의존성을 주입받기 위해, 클래스 바깥에 하나 dao 메서드를 만든다.
    private MemberDao memberDao;

    //dao 메서드로 넣을 memberDao를 의존성을 주입하는 방식으로 관리하기 위해,
    //외부에서 memberDao를 받아서 이 메서드에 있는 memberDao를 변경하는
    //메서드를 이 메서드의 기본생성자로 만들어주었다.
    public JoinService(MemberDao memberDao){
        this.memberDao = memberDao;
    }


    public void join(Member member){
        memberDao.insert(member);
    }

}
