import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int N, M, V;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    int from, to;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());

      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    for (int i = 0; i <= N; i++) {
      Collections.sort(graph.get(i));
    }

    visited = new boolean[N + 1];
    dfs(V);
    sb.setLength(sb.length() - 1);
    sb.append("\n");

    Arrays.fill(visited, false);
    bfs(V);
    sb.setLength(sb.length() - 1);

    System.out.print(sb.toString());
  }

  public static void dfs(int v) {
    visited[v] = true;
    sb.append(v).append(" ");

    for (int next : graph.get(v)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  public static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int v = queue.poll();
      sb.append(v).append(" ");

      for (int next : graph.get(v)) {
        if (!visited[next]) {
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }
}
