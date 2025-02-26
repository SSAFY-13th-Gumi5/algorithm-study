import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int N, M;
    static boolean result = false;  // result를 boolean으로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) { // 0부터 N-1까지 사용 (문제에서 0-based index 사용)
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
            if (result) break; // 친구 관계를 찾으면 더 이상 탐색할 필요 없음
        }

        System.out.println(result ? 1 : 0);
    }

    public static void dfs(int current, int depth) {
        if (depth == 4) { // 5개의 노드를 방문하면 종료
            result = true;
            return;
        }

        visited[current] = true;

        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (result) return; // 찾았으면 재귀 빠져나오기
            }
        }

        visited[current] = false; // 백트래킹
    }
}
