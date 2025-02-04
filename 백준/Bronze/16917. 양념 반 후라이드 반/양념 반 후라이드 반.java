
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();

        int result=0;
        int min=Math.min(x,y);
        int max=Math.max(x,y);

        //반반이 더 쌀 경우
        if((a+b)>(c*2)){
            //반반 제외 하고 나머지는 일반으로 결제하는 경우와, 모두 다 반반으로 결제하는 경우 중 더 싼 것을 출력
            result=Math.min((min*2*c)+((x-min)*a)+((y-min)*b),max*2*c);
        }else{
            result=(x*a)+(y*b);
        }

        System.out.println(result);
    }
}
