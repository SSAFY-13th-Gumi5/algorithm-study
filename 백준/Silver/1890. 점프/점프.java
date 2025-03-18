import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] grid;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        grid = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int next = grid[i][j];
                if (next == 0)
                    break;
                if (i + next < N)
                    dp[i + next][j] += dp[i][j];
                if (j + next < N)
                    dp[i][j + next] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);

    }
}