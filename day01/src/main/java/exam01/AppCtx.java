package exam01;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링에서 사용될 객체임을 의미한다.
public class AppCtx {

    @Bean //스프링에게 정보를 전달해 준다.
    public Hello hello(){
        //Hello 형태의 hello 객체를 만든다..
        Hello hello = new Hello();
        //만들어진 hello 객체를 반환한다.
        return hello;

        //즉, 이 객체는 스프링에서 사용될 AppCtx 클래스 안의 Hello 메서드이며,
        //이 Hello 메서드는 @Bean에 의해 스프링으로 관리받는 상태가 되었다.
        //이제 이 클래스, 메서드는 스프링 추가 애노테이션 등으로 관리가 되고 있는
        //상태임을 의미한다.
    }

}
