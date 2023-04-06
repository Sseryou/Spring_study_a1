package exam01;

public class ProxyCalculator implements Calculator{
    //다른 계산기의 기능을 대신 수행하는 계산기
    //데코레이터 디자인 패턴

    //의존성 주입 구조 시작
    private Calculator calculator;

    //기능을 2개 다 사용하고 싶다.
    //다형성을 이용하여 주입받기, 다양한 하위 클래스를 주입받을 수 있는 상태가 되었다.
    public ProxyCalculator(Calculator calculator){
        //Calculator 기능을 주입받을 수 있는 의존성 주입 상태를 구현하였다.
        this.calculator = calculator;
        //주입받은 기능을 적용시키기 위해 calculator로 보낸다.
    }
    //의존성 주입 구조 끝

    @Override
    public long factorial(long num) {
        //추가 기능을 붙여서 실행할수 있게 된 구조.
        //현재 추가 기능으로는 , 시간을 재는 공통기능이 있다.
        //추가 기능으로 무언가를 통제하게 할 수도 있다...(방화벽 구현 등..)
        long startTime = System.nanoTime(); //시작시간 - 공통기능

        //주입받아온 핵심 객체를 실행하는 구조.
        long result = calculator.factorial(num); //핵심 기능 (대신수행)

        long endTime = System.nanoTime(); //종료시간 - 공통기능
        System.out.printf("걸린 시간 : %d%n", endTime - startTime);
        return result;

    }

}
