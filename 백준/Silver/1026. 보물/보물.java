import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] B = new int[N];
    int sum = 0;
    boolean[][] isSelected = new boolean[2][N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(A);

    while (N-- > 0) {
      int A_min = Integer.MAX_VALUE;
      int B_max = Integer.MIN_VALUE;
      int A_index = 0;
      int B_index = 0;;

      for (int i = 0; i < A.length; i++) {
        if (A[i] < A_min && !isSelected[0][i]) {
          A_min = A[i];
          A_index = i;
        }
      }
      isSelected[0][A_index] = true;

      for (int i = 0; i < B.length; i++) {
        if (B[i] > B_max && !isSelected[1][i]) {
          B_max = B[i];
          B_index = i;
        }
      }
      isSelected[1][B_index] = true;

      sum += A_min * B_max;
    }
    System.out.println(sum);
  }

}