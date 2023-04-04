package exam02;

import models.member.JoinService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    //이 예제는 MVC 방식을 기존 사용방식과 다르게 Spring으로 구현해 본 것이다.
    //하지만 이제 View는 없는
    public static void main(String[] args) {
        //컨테이너 객체 생성.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        //AppCtx로 인해 관리받고 있는 "joinService"를 가져와, JoinService.class를 이용할 수 있게 해준다.
        //이 상태는, 의존성 주입 등 다양한 기능들을 스프링에서 제공받는 joinService를 가져와, service 객체형태로 만든것이다.
        //JoinService.class에 있는 기능을 사용한다고 명시하였기 때문에, 그 내부 기능을 사용할 수 있다. 메서드 등...
        JoinService service = ctx.getBean("joinService", JoinService.class);

        //lombok을 이용한 편리한 set호출
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setUserNm("사용자01");

        //위에서 설명한 대로, 기능을 사용한다고 명시하였기 때문에 내부에 구현한 기능인 join을 사용할 수 있게 되었다.
        service.join(member);

        ctx.close();
    }
}
