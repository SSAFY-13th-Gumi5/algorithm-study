

import java.io.*;
import java.util.*;

public class Main {

    static int [] visited;
    static ArrayList[] list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        parent = new int[N+1];
        list = new ArrayList[N+1];
        for (int i = 0; i <=N; i++) {
            list[i] = new ArrayList();
        }

        for(int i = 1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            list[a].add(b);
        }
        loop(1);
        for(int i = 2; i<=N; i++) {
            System.out.println(parent[i]);
        }
    }
    private static void loop(int n) {
        visited[n] = 1;
        for(int i =0; i <list[n].size(); i++) {
            int t = (int) list[n].get(i);
            if(visited[t] == 0) {
                parent[t] = n;
                loop(t);
            }

        }
    }

}