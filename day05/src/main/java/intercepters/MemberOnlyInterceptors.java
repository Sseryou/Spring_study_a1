package intercepters;

import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberOnlyInterceptors implements HandlerInterceptor {
    //접근,권한 통제, 공통기능 추가

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            //공통 데이터 설정
            request.setAttribute("commonData", "공통 데이터");
            //EL 식을 이용해서, 공통 데이터를 뽑아낼 수 도 있다.

            //request.getSession을 이용해서 세션을 받아와서 확인
            HttpSession session = request.getSession();
            //반환값 Object이므로 형변환 필요
            Member member = (Member)session.getAttribute("member");

            if(member != null){ //회원인 경우
                return true;
            }

            //회원이 아닌 경우 /study - request.getContextPath() + 로그인 화면으로 돌아가게 설계
            response.sendRedirect(request.getContextPath() + "/member/login");
            return false;
    }
}
