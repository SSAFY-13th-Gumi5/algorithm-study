
import java.util.Scanner;

class Solution
{
    static int[] arr;
    static int count =0;
    static int N;
    static int[] check;
    static int[] exponential = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
    static int[] factorial = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    static int total =0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            total = 0;
            count = 0;
             N = sc.nextInt();
            arr = new int[N];
            check = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
                total += arr[i];
            }
            int left_sum =0;
            int right_sum = 0;
            loop(0,left_sum,right_sum);
            System.out.println("#"+test_case+" "+count);
        }
    }
    static void loop(int depth,int leftSum, int rightSum){
        if(depth == N){
            count ++;
            return;
        }
        if(total-leftSum <= leftSum){
            count += exponential[N-depth] * factorial[N-depth];
            return ;
        }
        for(int i =0; i <N; i++){
            if(check[i] == 1)
                continue;
            check[i] = 1;
            loop(depth+1,leftSum+arr[i],rightSum);
            if(leftSum >= rightSum+arr[i]){
                loop(depth+1,leftSum,rightSum+arr[i]);
            }
            check[i] = 0;

        }

    }
}