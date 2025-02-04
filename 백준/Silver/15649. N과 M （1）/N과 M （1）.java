import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static boolean check[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        
        arr=new int[m];
        check=new boolean[n];
        dfs(n,m,0);

    }

    public static void dfs(int n, int m, int start){

        if(start==m){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(!check[i]){
                check[i]=true;
                arr[start]=i+1;
                dfs(n,m,start+1);

                check[i]=false; //백트래킹
            }
        }
    }
}
