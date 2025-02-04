
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] check;
    static int[][] arr; //간선 연결 용도
    static  int n, m,v;

    static StringBuilder sb=new StringBuilder();
    static Queue<Integer> q=new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        v=sc.nextInt();
        sc.hasNextLine();
        arr=new int[n+1][n+1];
        check=new boolean[n+1];

        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=arr[b][a]=1;
        }
        dfs(v);
        sb.append('\n');
        check=new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

   public static void dfs(int start){
        check[start]=true;
        sb.append(start+" ");

        for(int i=0; i<=n;i++){
            if(arr[start][i]==1 && !check[i]){
                dfs(i);
            }
        }

   }

   public static void bfs(int start){
        q.add(start);
        check[start]=true;

        while(!q.isEmpty()){
            start=q.poll();
            sb.append(start+" ");

            for(int i=1; i<=n; i++){
                if(arr[start][i]==1 && !check[i]){
                    q.add(i);
                    check[i]=true;
                }
            }
        }
   }
}
