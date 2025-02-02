import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int bfs(int start, int[] jump, boolean[] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int moves = cur[1];

            for (int i = 1; i <= 6; i++) {
                int next = (jump[pos + i] == 0) ? pos + i : jump[pos + i];
                if (next >= 100) return moves + 1;
                if (visited[next]) continue;

                visited[next] = true;
                q.add(new int[]{next, moves + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer;

        int[] edge = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edge[from] = to;
        }

        answer = bfs(1, edge, new boolean[101]);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
