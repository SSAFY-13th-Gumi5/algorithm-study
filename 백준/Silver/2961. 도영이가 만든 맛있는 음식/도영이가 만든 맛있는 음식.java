import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int N;
  static long result = Integer.MAX_VALUE;
  public static int[] S, B;

  private static void fun(int cnt, long sTotal, long bTotal, int count) {
    if (cnt == N) {
      if (count > 0) {
        result = Math.min(result, Math.abs(sTotal - bTotal));
      }
      return;
    }
    fun(cnt + 1, sTotal * S[cnt], bTotal + B[cnt], count + 1);

    fun(cnt + 1, sTotal, bTotal, count);

  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    S = new int[N];
    B = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      S[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
    }

    fun(0, 1, 0, 0);
    System.out.println(result);
  }
}