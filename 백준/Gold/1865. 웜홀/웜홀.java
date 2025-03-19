import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, W;
	static int[][] map;
	static final int INF = 1000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new int[N + 1][N + 1];
			// 웜홀 포함하여 map 하나만 사용
			for (int i = 1; i <= N; i++) {
				Arrays.fill(map[i], INF);
				map[i][i] = 0;
			}

			// 도로 입력 (양방향)
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				if (map[from][to] > cost) {
					map[from][to] = cost;
					map[to][from] = cost;
				}
			}

			// 웜홀 입력 (단방향 음수 간선)
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				if (map[from][to] > -cost) {
					map[from][to] = -cost;
				}
			}

			// 플로이드-워셜 수행
			for (int mid = 1; mid <= N; mid++) {
				for (int from = 1; from <= N; from++) {
					for (int to = 1; to <= N; to++) {
						if (map[from][to] > map[from][mid] + map[mid][to]) {
							map[from][to] = map[from][mid] + map[mid][to];
						}
					}
				}
			}
			// 음수 사이클 존재 여부 체크
			System.out.println(findWormHole() ? "YES" : "NO");
		}

		

	}

	private static boolean findWormHole() {
		for (int i = 1; i <= N; i++) {
			if (map[i][i] < 0)
				return true;
		}
		return false;
	}
}
