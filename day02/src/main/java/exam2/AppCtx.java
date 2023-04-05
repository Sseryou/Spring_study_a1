package exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {

    //이 객체가 만들어질때, init 메서드가 호출되고, 소멸될때, close 메서드가 호출된다.
    @Bean(initMethod = "init", destroyMethod = "close")
    @Scope("prototype")
    public Message message(){
        return new Message();
    }
}
