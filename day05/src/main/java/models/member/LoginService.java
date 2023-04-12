package models.member;

import controllers.members.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    @Autowired
    private HttpSession session;

    @Autowired
    private MemberDao memberDao;

    public void login(Login login){
        //1. 회원 데이터를 조회
        Member member = memberDao.get(login.getUserId());

        //2. 세션에 로그인 유지
        session.setAttribute("member", member);

    }

}
