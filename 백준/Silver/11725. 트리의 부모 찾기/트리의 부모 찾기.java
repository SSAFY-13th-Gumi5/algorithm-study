import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static List<List<Integer>> tree = new ArrayList<>(); // 트리를 저장할 리스트
  static int[] intarr; // 부모 노드를 저장할 배열
  static boolean[] visited; // 부모 노드가 이미 있는지 판별

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine()); // 노드의 개수
    intarr = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < N + 1; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i < N; i++) {
      String s = bf.readLine();
      StringTokenizer st = new StringTokenizer(s);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    dfs(1);

    for (int i = 2; i < N + 1; i++) {
      System.out.println(intarr[i]);
    }
  }

  private static void dfs(int i) {
    visited[i] = true;

    for (int child : tree.get(i)) {
      if (!visited[child]) {
        intarr[child] = i;
        dfs(child);
      }
    }

  }
}
