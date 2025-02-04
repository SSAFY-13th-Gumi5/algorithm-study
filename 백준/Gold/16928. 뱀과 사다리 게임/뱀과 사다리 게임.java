
import java.util.*;

public class Main {
    public static int[] board=new int[101];
    public static int[] check=new int[101];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(); //사다리
        int m=sc.nextInt(); //뱀
        sc.nextLine();


        for(int i=0; i<n+m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            board[a]=b;
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        check[1]=0; //시작 위치

        while (!queue.isEmpty()){
            int cur=queue.poll();

            if(cur==100){
                return check[cur];
            }
            for(int i=1; i<=6; i++){
                int next=i+cur;
                if(next>100) continue; //100번 칸 넘어가면 무효

                //해당 위치로 이동
                if(board[next]!=0){
                    next=board[next];
                }

                //방문하지 않은 곳이라면
                if(check[next]==0){
                    check[next]=check[cur]+1; //이동 횟수 추가
                    queue.add(next);
                }
            }

        }
        return -1;
    }
}
