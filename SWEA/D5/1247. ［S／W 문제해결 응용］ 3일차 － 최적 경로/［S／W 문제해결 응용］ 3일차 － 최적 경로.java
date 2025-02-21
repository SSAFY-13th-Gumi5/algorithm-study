import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


public class Solution {
  static Point company;
  static Point home;
  static ArrayList<Point> clients;
  static boolean[] visited;
  static int result;
  static int N;

  public static void dfs(int cnt, int sum, Point p) {
    if (cnt == N) {
      sum += Math.abs(p.x - home.x) + Math.abs(p.y - home.y);
      result = Math.min(result, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(cnt + 1, sum + Math.abs(p.x - clients.get(i).x) + Math.abs(p.y - clients.get(i).y),
            clients.get(i));
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {
      N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      clients = new ArrayList<>();
      visited = new boolean[N];
      result = Integer.MAX_VALUE;

      for (int i = 0; i < N; i++) {
        clients.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      dfs(0, 0, company);
      System.out.println("#" + tc + " " + result);
    }
  }
}