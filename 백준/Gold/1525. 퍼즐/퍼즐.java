import java.io.*;
import java.util.*;

class Main {
    static int[][] targetMap = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    static int[] dx = {0, 0, -1, 1}; // 좌우이동
    static int[] dy = {1, -1, 0, 0}; // 상하이동
    static HashSet<String> visited = new HashSet<>(); // 방문한 상태 저장

    static class State {
        int[][] map;
        int x, y, depth;

        State(int[][] map, int x, int y, int depth) {
            this.map = map;
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static int bfs(int[][] startMap, int startX, int startY) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startMap, startX, startY, 0));
        visited.add(getHash(startMap));

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int[][] map = cur.map;
            int x = cur.x, y = cur.y, depth = cur.depth;

            // 목표 상태에 도달했는지 확인
            if (Arrays.deepEquals(map, targetMap)) {
                return depth;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    int[][] newMap = deepCopy(map);
                    newMap[y][x] = newMap[ny][nx]; // 0 위치 변경
                    newMap[ny][nx] = 0;

                    String hash = getHash(newMap);
                    if (!visited.contains(hash)) {
                        visited.add(hash);
                        queue.add(new State(newMap, nx, ny, depth + 1));
                    }
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < 3; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static String getHash(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[3][3];
        int startX = -1, startY = -1;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    startY = i;
                    startX = j;
                }
            }
        }

        int result = bfs(map, startX, startY);
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}