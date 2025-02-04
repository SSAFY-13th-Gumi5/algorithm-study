
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int cnt=0;
        int end=0;
        int[][] arr=new int[n][2];
        for(int i=0; i<n; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[i][0]=a; //시작 시간
            arr[i][1]=b; //종료 시간
        }

        Arrays.sort(arr,(b1,b2)->{
            if(b1[1]==b2[1]){ //종료 시간이 같을 경우 시작 시간이 빠른 순
                return b1[0]-b2[0];
            }
            return b1[1]-b2[1];
        });
        
        for(int i=0; i<n; i++){
            if(end<=arr[i][0]){
                end=arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
