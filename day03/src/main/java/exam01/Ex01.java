package exam01;

public class Ex01 {
    public static void main(String[] args){
        //공통적으로 시간을 측정하는 부분을 핵심부분 사이에 넣었음
        // 프록시는 대신해서 공통기능을 핵심기능 전후에 실시함

        //기존 방식은, 공통기능과 핵심기능코드가 한 곳에 있어 복잡해짐.
        long startTime = System.nanoTime();

        ImplCalculator cal1 = new ImplCalculator();
        //핵심
        long result1 = cal1.factorial(10);
        System.out.printf("cal1=%d%n", result1);

        long endTime = System.nanoTime();
        System.out.printf("걸린시간:%d%n", endTime - startTime);


        //걸린 시간을 비교하면...재귀적 방식이 압도적으로 느리다...
        //시간측정 = 공통기능, 팩토리얼 계산은 다르게 된다.
        long startTime2 = System.nanoTime();

        RecCalculator cal2 = new RecCalculator();
        //핵심, 핵심기능 전후 공통기능 있음, 반복됨.
        long result2 = cal2.factorial(10);
        System.out.printf("cal2=%d%n", result2);

        long endTime2 = System.nanoTime();
        System.out.printf("걸린시간:%d%n", endTime2 - startTime2);

    }
}
