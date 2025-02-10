import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static String s;
  static int[] line;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    s = bf.readLine();
    line = new int[N];
    StringTokenizer st = new StringTokenizer(s);
    for (int i = 0; i < N; i++) {
      line[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = DP(line);
    System.out.println(line.length - result.length);
  }

  private static int[] DP(int[] line) {
    int n = line.length;
    int[] dp = new int[n];
    int[] prev = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(prev, -1);

    int maxLength = 0;
    int endIndex = 0;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (line[j] > line[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }

      if (dp[i] > maxLength) {
        maxLength = dp[i];
        endIndex = i;
      }
    }

    ArrayList<Integer> lds = new ArrayList<>();
    for (int i = endIndex; i != -1; i = prev[i]) {
      lds.add(line[i]);
    }

    return lds.stream().mapToInt(Integer::intValue).toArray();
  }

}
