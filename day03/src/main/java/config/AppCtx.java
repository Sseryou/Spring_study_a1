package config;



import exam02.Calculator;
import exam02.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass=true) //자동 프록시 설정, proxyTargetClass는 기본값이 false이고,
//true로 바꿔주면 기본적으로 프록시 속성이 인터페이스로 되어있는 것을 클래스로 바꾼다.
@EnableAspectJAutoProxy
public class AppCtx {
    //프록시는 public이 아니면 안된다.
    //프록시 자체가 다른 클래스를 불러와서 대신 수행하는 역할이기 때문이다.

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }



    /**
    @Bean
    public RecCalculator calculator(){
        return new RecCalculator();
    }

    @Bean
    public ImplCalculator calculator2(){
        return new ImplCalculator();
    }

     */
    @Bean
    public CachedProxy cachedProxy(){
        return new CachedProxy();
    }


    @Bean
    public ProxyCalculator2 proxyCalculator2(){
        return new ProxyCalculator2();
    }

    @Bean
    public CommonPointcut commonPointcut(){
        return new CommonPointcut();
    }


}
