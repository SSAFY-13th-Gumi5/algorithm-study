import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[30][30];

            sb.append(DP(M, N)).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static int DP(int M, int N) {

        if (dp[M][N] > 0) {
            return dp[M][N];
        }

        if (M == N || N == 0) {
            return dp[M][N] = 1;
        }

        return dp[M][N] = DP(M - 1, N - 1) + DP(M - 1, N);
    }
}