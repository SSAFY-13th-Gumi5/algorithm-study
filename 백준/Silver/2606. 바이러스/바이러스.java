import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int E;
    static int[][] grid;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());
        E = Integer.parseInt(bf.readLine());

        grid = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        result = -1;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            grid[from][to] = grid[to][from] = 1;
        }

        bfs(1);

        for (int i = 1; i <= N; i++) {
            if (visited[i])
                result++;
        }

        System.out.println(result);
    }

    private static void bfs(int index) {
        queue = new ArrayDeque<>();
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int next = 0; next < N + 1; next++) {
                if (grid[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}