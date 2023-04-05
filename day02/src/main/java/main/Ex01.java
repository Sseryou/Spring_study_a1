package main;

import config.AppCtx;
import config.AppCtx2;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //컨테이너가 찾아서 대입
        //JoinService joinService = ctx.getBean("joinService", JoinService.class);
        //클래스명만 입력해도 찾아준다.
        JoinService joinService = ctx.getBean(JoinService.class);
        ListService listService = ctx.getBean("listService", ListService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setUserNm("사용자01");
        joinService.join(member);

        listService.print();

        ctx.close();

    }

}
