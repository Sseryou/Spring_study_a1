package exam03.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        //넣는 클래스 이름과 반환할 클래스가 일치하여 암시적으로 대입
        TestDao dao = ctx.getBean(TestDao.class);
        dao.insert();


        ctx.close();
    }
}
