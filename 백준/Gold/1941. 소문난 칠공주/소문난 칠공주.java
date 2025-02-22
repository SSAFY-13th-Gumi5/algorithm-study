import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */


class Main {
    static char[][] map = new char[5][5];
    static int answer;
    static boolean[] selected;

    public static void makeComb(int idx, int n) { // idx 현재 선택된 사람, n 선택된 사람 수
        if (n == 7) {
            if (checkMap() && checkLinked())
                answer++;
            return;
        }
        for (int i = idx + 1; i < 25; i++) {
            selected[i] = true;
            makeComb(i, n + 1);
            selected[i] = false;
        }
    }

    private static boolean checkMap() {
        int cntS = 0;
        for (int i = 0; i < 25; i++) {
            if (!selected[i])
                continue;
            if (map[i / 5][i % 5] == 'S')
                cntS++;
        }
        return cntS >= 4;
    }

    public static boolean checkLinked() {
        Deque<Integer> q = new ArrayDeque<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        boolean[] visited = new boolean[25];
        for (int i = 0; i < 25; i++) {  //첫 시작 찾기
            if (selected[i]) {
                q.add(i);
                visited[i] = true;
                break;
            }
        }

        while (!q.isEmpty()) { //선택된 조합 탐색
            int cur = q.poll();
            int x = cur % 5;
            int y = cur / 5;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && selected[ny * 5 + nx] && !visited[ny * 5 + nx]) {
                    visited[ny * 5 + nx] = true;
                    q.add(ny * 5 + nx);
                }
            }
        }

        for (int i = 0; i < 25; i++) { // 선택된 사람이 모두 탐색 되면 참 아니면 거짓
            if (selected[i] != visited[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        selected = new boolean[25];
        answer = 0;
        makeComb(-1, 0);
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}