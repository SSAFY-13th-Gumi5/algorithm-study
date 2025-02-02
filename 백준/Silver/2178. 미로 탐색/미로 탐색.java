import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {


    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M, result = 0;
       
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Deque<Pair> queue = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        visited[0][0] = 1;
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.x == N - 1 && p.y == M - 1) {
                result = visited[p.x][p.y];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny] != 0 || map[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = visited[p.x][p.y] + 1;
                queue.add(new Pair(nx, ny));
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}