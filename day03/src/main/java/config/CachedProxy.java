package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Order(1)
@Aspect
public class CachedProxy {

    private Map<Long, Object> cacheData = new HashMap<>();



    //모든 반환형, exam02을 포함한 모든 하위 패키지+ 모든 클래스 중
    // 매개변수를 long으로 받는 클래스



    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint)throws Throwable{
        //현재 매개변수가 얼마가 있을지 모르므로 배열 형태로 받아온다.
        Object[] args = joinPoint.getArgs();
        Long num = (long)args[0];

        if(cacheData.containsKey(num)){
            //기존 데이터가 있으면 캐시 데이터 사용
            System.out.printf("[%d] 캐시 사용 \n", num);
            return cacheData.get(num);
        }

        //다음 프록시가 있으면 다음 프록시가 수행되고 -> factorial 프록시
        // , 없으면 종료
        Object result = joinPoint.proceed();

        //없으면 캐시에 기록
        cacheData.put(num, result);
        System.out.printf("[%d] 캐시 추가\n", num);

        return result;
    }

}
