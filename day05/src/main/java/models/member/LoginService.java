package models.member;

import controllers.members.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    @Autowired
    private HttpSession session;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private HttpServletResponse response;

    public void login(Login login){
        //1. 회원 데이터를 조회
        Member member = memberDao.get(login.getUserId());

        //2. 세션에 로그인 유지
        session.setAttribute("member", member);

        //3. 아이디 저장 쿠키 저장처리
        Cookie cookie = new Cookie("saveId", member.getUserId());
        if(login.isSaveId()){ //아이디 저장 체크시 (등록)
            cookie.setMaxAge(60*60*24*365); //1년동안 쿠키 보관
        } else { //아이디 저장 미 체크시 (삭제)
            cookie.setMaxAge(0); //0초동안 쿠키 보관(삭제.)
        }

        response.addCookie(cookie);

    }

}
