import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge(int v, int w) {
      super();
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return this.w - o.w;
    }
  }

  static int V, E;
  static int start;
  static List<Edge>[] adjList;
  static boolean[] visited;
  static int INF = 9999999;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    adjList = new ArrayList[V + 1];

    for (int i = 1; i <= V; i++) {
      adjList[i] = new ArrayList<>();
    }

    start = Integer.parseInt(br.readLine());

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      adjList[u].add(new Edge(v, w));
    }


    visited = new boolean[V + 1];
    int[] distance = new int[V + 1];
    Arrays.fill(distance, INF);
    distance[start] = 0;

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));

    while (!pq.isEmpty()) {
      Edge cur = pq.poll();
      int current = cur.v;

      if (visited[current]) {
        continue;
      }

      visited[current] = true;

      for (Edge e : adjList[current]) {
        if (distance[e.v] > distance[current] + e.w) {
          distance[e.v] = distance[current] + e.w;
          pq.add(new Edge(e.v, distance[e.v]));
        }
      }
    }
    for (int i = 1; i <= V; i++) {
      if (distance[i] == INF) {
        sb.append("INF\n");
      } else {
        sb.append(distance[i] + "\n");
      }
    }
    System.out.println(sb);
  }

}