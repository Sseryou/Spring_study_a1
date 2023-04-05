package exam2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        //컨테이너가 생성 되었기 때문에, init 메서드 실행

        //만약 객체를 만드는 과정이 있다면, 그 때 init를 실행한다.
        //@Scope("prototype") 사용시, 싱글톤 패턴이 아닌 객체를 생성하게 되므로,
        //객체를 다른이름으로 만들때마다 init가 호출이 된다.
        //따라서, 이 클래스는 init를 2번 호출하게 된다.

        //단순히, 만든 객체를 조회하는 과정이다.
        Message message = ctx.getBean(Message.class);
        message.send("메세지!");

        Message message2 = ctx.getBean(Message.class);

        System.out.println(message == message2);
        //싱글톤 패턴이면 true가 나옴. true
        //@Scope로 매번 인스턴스를 생성하도록 설정하였기 때문에,
        //서로 다른 객체가 된다.

        ctx.close();
    }

}
