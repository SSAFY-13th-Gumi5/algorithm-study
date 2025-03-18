import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<List<Integer>> graph;
    static int[] dist;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        queue.add(X);
        dist[X] = 0;
        bfs();

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int next : graph.get(idx)) {
                if (dist[next] == -1) {
                    dist[next] = dist[idx] + 1;
                    queue.add(next);
                }
            }
        }
    }
}