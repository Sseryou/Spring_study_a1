package exam01;

public class Ex02 {
    public static void main(String[] args) {

        //ImplCalculator를 주입받은 ProxyCalculator
        //뒤를 지우면 프록시인지 아닌지 알기 힘들다.. 뒤에있는 구현부분을 보아야함..
        Calculator cal1 = new ProxyCalculator(new ImplCalculator());
        //RecCalculator를 주입받은 ProxyCalculator
        Calculator cal2 = new ProxyCalculator(new RecCalculator());

        printResult(cal2);

    }

    public static void printResult(Calculator cal){
        long result = cal.factorial(10);
        System.out.printf("cal=%d%n", result);
    }

}
