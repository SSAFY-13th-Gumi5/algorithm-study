import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int city, cost;
    
    public Node(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Node>> graph;
    static int[] dist;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.city;
            int nowCost = current.cost;

            if (dist[now] < nowCost) continue;

            for (Node next : graph.get(now)) {
                int newCost = dist[now] + next.cost;

                if (newCost < dist[next.city]) {
                    dist[next.city] = newCost;
                    pq.offer(new Node(next.city, newCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }
}
