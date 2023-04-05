package exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        //컨테이너객체
        //클래스의 정보를 담는다. 담은 객체는 Spring이 다양한 방식으로 관리하게 된다.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //Hello 객체를 "스프링을 이용해서" 만들었다.
        //그 후 AnnotationConfigApplicationContext(AppCtx.class)
        //AppCtx.class의 정보를 담은 객체 ctx를 만들어준다.
        //AppCtx.class는 반환형이 Hello인 hello를 내장하고 있는 상태이다.
        //hello를 반환하는 상태로 저장이 된 상태이다.
        Hello hello = ctx.getBean("hello", Hello.class);
        //Hello 형태의 hello 객체를 컨테이너에서 끌어와서 만든다.
        //컨테이너 객체(ctx) 에 getBean을 이용하여, 이름이 hello인 빈 객체를 구한다.
        //이 메서드는 Hello 객체의 생성자를 통해 hello를 주입한다.
        //따라서 이 Hello 객체는 내부에서 hello 빈 객체를 사용한다.

        hello.greet("이이름");
        //hello 객체에, Hello 클래스에 있는 기능인 greet를 사용할 수 있게 되었다.


        Hello hello2 = ctx.getBean("hello", Hello.class);

        hello2.greet("김이름");

        System.out.println(hello == hello2);
        //두 객체가 서로 다른 이름을 지정햇음에도 같다고 나온다.
        //이는 스프링이 객체를 싱글톤 패턴으로 관리 한다는 것을 의미한다.

        ctx.close();
        //스프링은 사용햇으면 닫아주어야 한다...
    }

}
