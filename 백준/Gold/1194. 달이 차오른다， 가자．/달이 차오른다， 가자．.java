import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][][] visit;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		visit = new boolean[1 << 6][N][M];
		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int k = 0; k < M; k++) {
				map[i][k] = str.charAt(k);
				if (map[i][k] == '0') {
					start[0] = i;
					start[1] = k;
				}
			}
		}

		bfs(start[0], start[1]);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	public static void bfs(int y, int x) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { y, x, 0, 1 });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = tmp[1] + dx[i];
				int ny = tmp[0] + dy[i];
				int v = tmp[2];

				if (0 <= nx && nx < M && 0 <= ny && ny < N && !visit[v][ny][nx] && map[ny][nx] != '#') {
					if (!Character.isUpperCase(map[ny][nx])) {
						if (map[ny][nx] == '1') {
							result = tmp[3];
							return;
						}

						visit[v][ny][nx] = true;
						if (Character.isLowerCase(map[ny][nx])) {
							v = v | 1 << (map[ny][nx] - 'a');
						}
						queue.offer(new int[] { ny, nx, v, tmp[3] + 1 });
					} else {
						if ((v & (1 << (map[ny][nx] - 'A'))) != 0) {
							if (map[ny][nx] == '1') {
								result = Math.min(result, tmp[3]);
							}

							visit[v][ny][nx] = true;
							if (Character.isLowerCase(map[ny][nx])) {
								v = v | 1 << (map[ny][nx] - 'a');
							}
							queue.offer(new int[] { ny, nx, v, tmp[3] + 1 });
						}
					}
				}
			}
		}
	}

}
