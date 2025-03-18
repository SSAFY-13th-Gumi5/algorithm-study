
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N,M;
    static ArrayList<Integer>[] arr1;
    static ArrayList<Integer>[] arr2;
    static int[] visited;
    static int result;
    static int cnt_go;
    static int cnt_back;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            arr1 = new ArrayList[N];
            arr2 = new ArrayList[N];
            //visited = new int[N];
            result =0;
            for(int i = 0; i < N; i++) {
                arr1[i] = new ArrayList<>();
                arr2[i] = new ArrayList<>();
            }
            for(int i =0; i < M; i ++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr1[a-1].add(b-1);
                arr2[b-1].add(a-1);
            }
            for(int i = 0; i < N; i++) {
                visited = new int[N];
                cnt_go = 0;
                cnt_back = 0;
                dfs(i);
                visited = new int[N];
                dfs_back(i);
                if(cnt_back+cnt_go == N-1) {
                    result ++;
                }
                //System.out.println(arr1[3].get(1));
                //System.out.println(cnt_go);
                //System.out.println(cnt_back);
            }
            System.out.println("#"+tc+" "+result);

        }
    }
    private static void dfs(int start) {
        for(int i = 0; i < arr1[start].size(); i ++){
            //System.out.print("test");
            if(visited[arr1[start].get(i)] ==0){
               // System.out.print("test2");
                visited[arr1[start].get(i)] = 1;
                cnt_go++;
                dfs(arr1[start].get(i));
                //visited[start] = 0;
            }
        }
    }
    private static void dfs_back(int start) {

//        for(int i = 0; i < arr2[start].size(); i ++){
//            if(visited[start] ==0){
//                visited[start] = 1;
//                dfs_back(arr2[start].get(i),depth+1);
//                //visited[start] = 0;
//            }
//        }
        for( int next : arr2[start]) {
            if(visited[next] == 0){
                visited[next] = 1;
                cnt_back++;
                dfs_back(next);
            }
        }
    }
}
