package main;

import config.AppCtx;
import lombok.extern.java.Log;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Log //lombok에서 Log 변수 추가
public class Ex01 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        MemberDao memberDao = ctx.getBean(MemberDao.class);

        Member member = new Member();
        member.setUserId("user03");
        member.setUserPw("123456");
        member.setUserNm("사용자03");

        long userNo = memberDao.insert(member);
        System.out.println("추가 성공 : " + userNo);


        /**
        boolean result = memberDao.delete("user02");
        System.out.println("삭제 성공 : " + result);
        */

        /**
        List<Member> members = memberDao.gets();
        members.stream().forEach(System.out::println);
        */

        /**
        Member member = memberDao.get("user03");

        if (member != null) {
            log.info(member.toString());
        }
         */

        long total = memberDao.getTotal();
        log.info("총 회원 수 : " + total);

        ctx.close();
    }
}
