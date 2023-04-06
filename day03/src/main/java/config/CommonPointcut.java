package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class CommonPointcut {
    @Pointcut("execution(* exam02..*(..))") //공통 범위를 exam02 패키지로 한정함.
    public void publicTarget(){}
}
