package exam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args){
        //설정 클래스를 넣어야 한다. AppCtx...
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //객체 주입 완료 후 조회 시점
        Message message = ctx.getBean(Message.class);

        //스프링 컨테이너가 생성후, 스프링 내부에서 객체 의존성 및 주입을 하고,
        // 그 객체에 주입을 하는 과정에서
        // afterPropertiesSet()이 먼저 실행된다.
        // afterPropertiesSet()를 오버라이드하여 수정하는 것으로,
        //객체 주입 후 초기화 과정에서의 값을 변경할 수 있다.
        message.send("메세지");

        ctx.close();

    }
}
