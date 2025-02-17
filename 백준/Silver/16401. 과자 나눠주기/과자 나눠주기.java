import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int child=sc.nextInt();
        int snack=sc.nextInt();
        int[] snackArr=new int[snack];
        int result=0;
        for(int i=0; i<snack; i++){
            snackArr[i]=sc.nextInt();
        }
        Arrays.sort(snackArr);
        int  low=1; //가장 작은 과자 길이
        int high=snackArr[snack-1];

        while (low<=high){
            int mid=(low+high)/2;
            int cnt=0;
            for(int s:snackArr){
                cnt+=s/mid;
            }

            if(cnt>=child){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        System.out.println(result);
    }
}
