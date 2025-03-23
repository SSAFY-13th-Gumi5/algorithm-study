import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static class Cctv {
    int num, x, y;

    public Cctv(int num, int x, int y) {
      this.num = num;
      this.x = x;
      this.y = y;
    }
  }

  static int N, M;
  static int[][] map;
  static List<Cctv> cctvs = new ArrayList<>();
  static int result = Integer.MAX_VALUE;

  public static void left(int[][] arr, Cctv cctv) {
    int i = cctv.x;
    while (i >= 0 && arr[cctv.y][i] != 6) {
      if (arr[cctv.y][i] == 0)
        arr[cctv.y][i] = -1;
      i--;
    }
  }

  public static void right(int[][] arr, Cctv cctv) {
    int i = cctv.x;
    while (i < M && arr[cctv.y][i] != 6) {
      if (arr[cctv.y][i] == 0)
        arr[cctv.y][i] = -1;
      i++;
    }
  }

  public static void up(int[][] arr, Cctv cctv) {
    int i = cctv.y;
    while (i >= 0 && arr[i][cctv.x] != 6) {
      if (arr[i][cctv.x] == 0)
        arr[i][cctv.x] = -1;
      i--;
    }
  }

  public static void down(int[][] arr, Cctv cctv) {
    int i = cctv.y;
    while (i < N && arr[i][cctv.x] != 6) {
      if (arr[i][cctv.x] == 0)
        arr[i][cctv.x] = -1;
      i++;
    }
  }

  public static int sumBlind(int[][] tmp) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int k = 0; k < M; k++) { // k로 변경
        if (tmp[i][k] == 0)
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < M; k++) {
        int n = Integer.parseInt(st.nextToken());
        map[i][k] = n;
        if (n != 0 && n != 6) {
          cctvs.add(new Cctv(n, k, i));
        }
      }
    }

    dfs(0, map);
    System.out.println(result);
  }

  private static void dfs(int cnt, int[][] arr) {
    if (cnt == cctvs.size()) {
      result = Math.min(result, sumBlind(arr));
      return;
    }

    Cctv cctv = cctvs.get(cnt);
    int[][] copy;

    if (cctv.num == 1) {
      for (int i = 0; i < 4; i++) {
        copy = deepCopy(arr);
        if (i == 0)
          left(copy, cctv);
        if (i == 1)
          right(copy, cctv);
        if (i == 2)
          up(copy, cctv);
        if (i == 3)
          down(copy, cctv);
        dfs(cnt + 1, copy);
      }
    } else if (cctv.num == 2) {
      for (int i = 0; i < 2; i++) {
        copy = deepCopy(arr);
        if (i == 0) {
          left(copy, cctv);
          right(copy, cctv);
        } else {
          up(copy, cctv);
          down(copy, cctv);
        }
        dfs(cnt + 1, copy);
      }
    } else if (cctv.num == 3) {
      for (int i = 0; i < 4; i++) {
        copy = deepCopy(arr);
        if (i == 0) {
          up(copy, cctv);
          right(copy, cctv);
        } else if (i == 1) {
          right(copy, cctv);
          down(copy, cctv);
        } else if (i == 2) {
          down(copy, cctv);
          left(copy, cctv);
        } else {
          left(copy, cctv);
          up(copy, cctv);
        }
        dfs(cnt + 1, copy);
      }
    } else if (cctv.num == 4) {
      for (int i = 0; i < 4; i++) {
        copy = deepCopy(arr);
        if (i == 0) {
          left(copy, cctv);
          right(copy, cctv);
          up(copy, cctv);
        } else if (i == 1) {
          up(copy, cctv);
          right(copy, cctv);
          down(copy, cctv);
        } else if (i == 2) {
          right(copy, cctv);
          down(copy, cctv);
          left(copy, cctv);
        } else {
          up(copy, cctv);
          left(copy, cctv);
          down(copy, cctv);
        }
        dfs(cnt + 1, copy);
      }
    } else if (cctv.num == 5) {
      copy = deepCopy(arr);
      up(copy, cctv);
      left(copy, cctv);
      down(copy, cctv);
      right(copy, cctv);
      dfs(cnt + 1, copy);
    }
  }

  private static int[][] deepCopy(int[][] arr) {
    int[][] copy = new int[N][M];
    for (int i = 0; i < N; i++) {
      copy[i] = arr[i].clone();
    }
    return copy;
  }
}