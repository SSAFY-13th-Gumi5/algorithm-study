import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  // 전부 static 으로 설정해야 함
  static boolean[][] visited; // 방문여부
  static int[] dx = {-1, 1, 0, 0}; // 상하
  static int[] dy = {0, 0, -1, 1}; // 좌우
  static int N;
  static int M;
  static int[][] maze; // 미로

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    StringTokenizer st = new StringTokenizer(s);
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    maze = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = bf.readLine();
      int j = 0;
      for (char c : line.toCharArray()) {
        // '0'을 안하면 char c를 아스키 코드로 판단해서 0일때 48, 1일때 49가 배열에 들어가버림
        maze[i][j] = c - '0';
        j++;
      }
    }

    visited = new boolean[N][M];
    visited[0][0] = true;
    bfs(0, 0);
    System.out.println(maze[N - 1][M - 1]);
  }

  public static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {x, y});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curX = cur[0];
      int curY = cur[1];

      for (int i = 0; i < 4; i++) {
        // 현재 위치에서 상하좌우 탐색
        int nextX = curX + dx[i]; // 현재 위치의 상하
        int nextY = curY + dy[i]; // 현재 위치의 좌우

        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) // 미로를 벗어나는 경우
          continue;
        if (visited[nextX][nextY] || maze[nextX][nextY] == 0)
          continue;

        queue.add(new int[] {nextX, nextY});
        visited[nextX][nextY] = true;
        maze[nextX][nextY] = maze[curX][curY] + 1; // 시작 지점에서 다른 칸까지의 최소 거리를 누적해서 계산
      }
    }
  }
}
