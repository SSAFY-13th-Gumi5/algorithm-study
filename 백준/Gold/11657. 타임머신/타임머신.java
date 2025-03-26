import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 시작점: 1번 도시

        for (int i = 1; i < N; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        // 음수 사이클 판별
        boolean hasCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                hasCycle = true;
                break;
            }
        }

        // 출력
        if (hasCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        }
    }
}
