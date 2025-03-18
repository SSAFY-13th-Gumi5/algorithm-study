import java.io.*;
import java.util.*;

public class Main {
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    static int[][] arr;
    static int n;
    static int m;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0 ; i < K; i ++){
            st = new StringTokenizer(br.readLine());
            int left_x = Integer.parseInt(st.nextToken());
            int left_y = Integer.parseInt(st.nextToken());
            int right_x = Integer.parseInt(st.nextToken());
            int right_y = Integer.parseInt(st.nextToken());
            for(int y=left_y; y<right_y; y++) {
                for(int x=left_x; x<right_x; x++){
                    arr[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> arr_count = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    count = 0; //영역 개수 초기화
                    dfs(i,j);
                    arr_count.add(count);
                }
            }
        }

        Collections.sort(arr_count); //오름차순 정렬


        System.out.println(arr_count.size());
        for(int i=0; i<arr_count.size(); i++) {
            System.out.print(arr_count.get(i)+" ");
        }

    }

    private static void dfs(int x, int y) {
        arr[x][y] = 1;
        count ++;
        for(int idx =0; idx < 4; idx ++){
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if(0<=nx && nx<n && 0<=ny && ny < m) {
                if(arr[nx][ny] == 0) {
                    dfs(nx,ny);
                }
            }
        }
    }


}
