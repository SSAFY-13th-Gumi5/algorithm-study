import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s = bf.readLine();
    StringTokenizer st = new StringTokenizer(s);
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] list = new int[N];
    boolean[] used = new boolean[N];
    int[] result = new int[M];
    for (int i = 0; i < N; i++) {
      list[i] = i + 1;
      used[i] = false;
    }

    sequence(list, result, used, 0, M);
  }

  private static void sequence(int[] list, int[] result, boolean[] used, int first, int end) {
    if (first == end) {
      for (int num : result) {
        System.out.print(num + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < list.length; i++) {
      if (!used[i]) {
        used[i] = true;
        result[first] = list[i];
        sequence(list, result, used, first + 1, end);
        used[i] = false;
      }
    }
  }
}
