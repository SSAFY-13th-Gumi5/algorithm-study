
import java.util.*;

public class Main {
    public static int n=0;
    public static int[] parent;
    public static ArrayList<Integer>[] list;
    public static boolean[] check;//연결리스트 배열
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        sc.nextLine();
        parent=new int[n+1];
        list=new ArrayList[n+1];
        check=new boolean[n+1];
        
        //리스트 배열 초기화
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1;i++){
            int num1=sc.nextInt();
            int num2=sc.nextInt();

            list[num1].add(num2);
            list[num2].add(num1);

        }
        bfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        check[start]=true;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int i:list[cur]){
                if(check[i]){
                    continue;
                }
                check[i]=true;
                q.add(i);
                parent[i]=cur;

            }
        }

    }
}
