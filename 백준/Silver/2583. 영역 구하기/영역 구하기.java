import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int map[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                if (map[i][k] == 0) {
                    count = 0;
                    dfs(i, k);
                    arr.add(count);
                }
            }
        }

        Collections.sort(arr);

        sb.append(arr.size()).append("\n");

        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}
