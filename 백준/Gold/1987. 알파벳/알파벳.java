import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int R;
    private static int C;
    private static int[][] board;
    private static boolean[] visited;
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String a = bf.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = a.charAt(j) - 'A';
            }
        }

        visited[board[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                if (!visited[board[nextX][nextY]]) {
                    visited[board[nextX][nextY]] = true;
                    dfs(nextX, nextY, cnt + 1);
                    visited[board[nextX][nextY]] = false;
                }
            }
        }
    }
}
