import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int I;
    static int sX;
    static int sY;
    static int eX;
    static int eY;
    static StringBuilder sb;
    static int[][] chess;
    static boolean[][] visited;
    static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static Queue<Integer[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st = null;
        sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            I = Integer.parseInt(bf.readLine());
            chess = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(bf.readLine());
            sX = Integer.parseInt(st.nextToken());
            sY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            eX = Integer.parseInt(st.nextToken());
            eY = Integer.parseInt(st.nextToken());

            BFS(sX, sY);
        }
        System.out.println(sb.toString());
    }

    private static void BFS(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new Integer[] { x, y });
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            if (curX == eX && curY == eY) {
                System.out.println(chess[curX][curY]);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < I && nextY >= 0 && nextY < I) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        chess[nextX][nextY] = chess[curX][curY] + 1;
                        queue.offer(new Integer[] { nextX, nextY });
                    }
                }
            }
        }
    }
}