
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static int n;
    public static int m;
    public static int[][] arr;
    public static boolean[][] check;
    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();

        arr=new int[n][m];
        check=new boolean[n][m];

        for(int i=0; i<n; i++){
            String line=sc.nextLine();
            for(int j=0; j<m; j++){
                //공백이 없는 경우에는 문자열로 받아서 처리하기
                arr[i][j]=line.charAt(j)-'0'; //문자를 숫자로 변환
            }
        }

        System.out.println(bfs(0,0));

    }
    public static int bfs(int startX, int startY){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{startX,startY,1}); //시작 위치랑 이동 거리 초기화
        check[startX][startY]=true;

        //큐가 비기 전까지 계속 반복
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            int d=cur[2]; //이동 거리(출력해야 하는 값)

            if(x==n-1&&y==m-1) return d;

            for(int i=0; i<4; i++){
                int checkX=x+dx[i];
                int checkY=y+dy[i];

                if(checkX>=0&&checkY>=0&&checkX<n&&checkY<m&&!check[checkX][checkY]&&arr[checkX][checkY]==1){
                    check[checkX][checkY]=true;
                    queue.add(new int[]{checkX,checkY,d+1});
                }
            }
        }
        return -1;
    }
}
