
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

       int n=sc.nextInt();

       int cnt=0;
       int result=n;

       while (true){
           n=((n%10)*10)+(((n/10)+(n%10))%10);
           cnt++;
           if(n==result){
               break;
           }
       }
        System.out.println(cnt);
    }
}
