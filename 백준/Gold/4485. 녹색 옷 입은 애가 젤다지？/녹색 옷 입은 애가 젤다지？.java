import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[][] map;
  static int[][] dp;
  // 우 하 좌 상
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int tc = 0;

    while (true) {
      N = Integer.parseInt(br.readLine());
      if (N == 0) {
        break;
      }

      tc++;

      map = new int[N][N];
      dp = new int[N][N];

      for (int i = 0; i < N; i++) {
        Arrays.fill(dp[i], 100000);
      }

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      dp[0][0] = map[0][0];
      bfs();
      sb.append("Problem " + tc + ": " + dp[N - 1][N - 1] + "\n");
    }
    System.out.println(sb);
  }

  private static void bfs() {
    Queue<int[]> queue = new ArrayDeque<int[]>();
    queue.offer(new int[] {0, 0});

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int y = current[0];
      int x = current[1];

      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (0 <= ny && ny < N && 0 <= nx && nx < N) {
          if (dp[y][x] + map[ny][nx] < dp[ny][nx]) {
            dp[ny][nx] = dp[y][x] + map[ny][nx];
            queue.offer(new int[] {ny, nx});
          }
        }
      }
    }
  }

}