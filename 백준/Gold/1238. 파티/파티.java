import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, t));
        }

        int[] distFromX = dijkstra(X, N, graph);

        ArrayList<Edge>[] reversedGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            reversedGraph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            for (Edge edge : graph[i]) {
                reversedGraph[edge.to].add(new Edge(i, edge.time));
            }
        }

        int[] distToX = dijkstra(X, N, reversedGraph);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
            }
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(int start, int N, ArrayList<Edge>[] graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.to;
            int currentTime = current.time;

            if (currentTime > dist[node]) continue;

            for (Edge edge : graph[node]) {
                int newTime = currentTime + edge.time;
                if (newTime < dist[edge.to]) {
                    dist[edge.to] = newTime;
                    pq.add(new Edge(edge.to, newTime));
                }
            }
        }

        return dist;
    }
}
