package exam01;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean //스프링에게 정보를 전달해 준다.
    public Hello hello(){
        Hello hello = new Hello();
        return hello;
    }

}
