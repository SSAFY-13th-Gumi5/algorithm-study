import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] grid;
    static Queue<Integer[]> queue;
    static boolean[][] visited;
    static boolean checked;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(bf.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        System.out.println(checked ? "HaruHaru" : "Hing");
    }

    private static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new Integer[] { x, y });

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int value = grid[curX][curY];
            if (value == -1) {
                checked = true;
                return;
            }
            int[] dx = { 0, 1 };
            int[] dy = { 1, 0 };
            for (int i = 0; i < 2; i++) {
                dx[i] *= value;
                dy[i] *= value;
            }

            for (int i = 0; i < 2; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < N && nextY < N && !visited[nextX][nextY]) {
                    queue.add(new Integer[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}