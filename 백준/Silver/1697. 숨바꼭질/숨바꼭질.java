import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int[] visit = new int[100001];
  static int MAX_POINT = 100000;

  public static void bfs(int n) {
    Deque<Integer> deque = new ArrayDeque<>();

    deque.add(n);
    visit[n] = 1;

    while (!deque.isEmpty()) {
      int q = deque.poll();

      if (q == K) {
        System.out.println(visit[q] - 1);
        return;
      }

      if (0 <= (q - 1) && (q - 1) <= MAX_POINT && visit[q - 1] == 0) {
        visit[q - 1] = visit[q] + 1;
        deque.add(q - 1);
      }

      if (0 <= (q + 1) && (q + 1) <= MAX_POINT && visit[q + 1] == 0) {
        visit[q + 1] = visit[q] + 1;
        deque.add(q + 1);
      }

      if (0 <= (q * 2) && (q * 2) <= MAX_POINT && visit[q * 2] == 0) {
        visit[q * 2] = visit[q] + 1;
        deque.add(q * 2);
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    bfs(N);
  }

}