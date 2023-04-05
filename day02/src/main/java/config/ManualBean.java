package config;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) //어느 시점에 실행할 것인가? -> 런타임
public @interface ManualBean {
    //스캔 범위 제어를 위한 인터페이스
}
