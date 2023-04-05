package exam;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Message implements InitializingBean , DisposableBean {
    //메세지를 보내는 기능을 구현할 메서드.
    public void send(String msg){
        System.out.printf("전송 메세지 : %s%n", msg);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //의존 설정 후, 초기화 단계에서 실행
        System.out.println("AfterPropertySet!!");
    }

    @Override
    public void destroy() throws Exception {
        //컨테이너 닫히기 직전 호출
        //소멸 과정이 없다면, 호출되지 않는다.
        System.out.println("Destroy!!!");
    }
}
