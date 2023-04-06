package config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect //공통 기능을 구현할 클래스임을 명시
public class ProxyCalculator2 {

    //프록시가 많고, 범위가 공통되면 포인트컷만 따로 관리하는것도 가능하다.
    /*
    @Pointcut("execution(* exam02..*(..))") //공통 범위를 exam02 패키지로 한정함.
    public void publicTarget(){}
    //CommonPointcut으로 옮김
    */

    //모든 메서드의 반환값에 대응하기 위해 Object로 설정
    //반환값, 매개변수, 예외처리부분은 정해져 있다.

    @Around("config.CommonPointcut.publicTarget()")
    //Around에 범위를 직접 넣어주는것도 된다.
    //공통기능, 범위를 만든 메서드를 불러오게 되면 동작
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        long startTime = System.nanoTime(); //공통기능

        //프록시가 대신 핵심기능 수행
        //인터페이스가 생성되고, 가상의 클래스가 수행된다.
        Object result = joinPoint.proceed(); //핵심 기능 수행

        long endTime = System.nanoTime(); //공통기능

        System.out.printf("걸린시간 : %d%n", endTime - startTime);

        return result;
    }


}
