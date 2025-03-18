import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int max;
    static int cnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(bf.readLine());

        grid = new int[N][N];
        visited = new boolean[N][N];
        result = -1;
        max = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }

        for (int i = 0; i < max; i++) {
            visited = new boolean[N][N];
            water(i);
            cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        cnt++;
                        visited[j][k] = true;
                        dfs(j, k);
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }

    private static void water(int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }
    }
}