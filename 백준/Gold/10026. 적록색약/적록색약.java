import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;
        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int k = 0; k < n; k++) {
                map[i][k] = str.charAt(k);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (!visit[i][k]) {
                    dfs(i, k);
                    result++;
                }
            }
        }

        int general = result;
        result = 0;

        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (map[i][k] == 'G') {
                    map[i][k] = 'R';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (!visit[i][k]) {
                    dfs(i, k);
                    result++;
                }
            }
        }

        int ColorBlindness = result;

        System.out.println(general + " " + ColorBlindness);
    }
    public static void dfs(int y, int x) {
        visit[y][x] = true;
        char color = map[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx] && map[ny][nx] == color) {
                dfs(ny, nx);
            }
        }
    }

}