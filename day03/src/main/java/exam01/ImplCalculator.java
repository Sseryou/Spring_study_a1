package exam01;

public class ImplCalculator implements Calculator{

    public long factorial(long num) {

        int total = 1;
        //간단하게 반복문으로 팩토리얼 예제 풀이
        for(int i = 1; i <= num; i++){
            total *= i;
        }

        return total;
        //나머지 하나는 재귀적 방식으로 본인함수를 계속 호출하는 방식으로..

    }
}
