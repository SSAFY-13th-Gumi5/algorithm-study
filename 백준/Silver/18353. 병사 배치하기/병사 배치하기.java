import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int[] arr=new int[n];
        int[] dp=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        int result=0;
        for(int i=0; i<n; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }


        System.out.println(n-result);

    }

}
