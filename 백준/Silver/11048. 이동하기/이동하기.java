import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = miro[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N)
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + miro[i + 1][j]);
                if (j + 1 < M)
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + miro[i][j + 1]);
                if (i + 1 < N && j + 1 < M)
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + miro[i + 1][j + 1]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}