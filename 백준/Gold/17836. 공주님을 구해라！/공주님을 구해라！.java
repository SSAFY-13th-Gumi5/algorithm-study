import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;
	int dist;
	boolean hasBomb;

	public Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.hasBomb = false;
	}

	public Node(int x, int y, int dist, boolean bomb) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.hasBomb = bomb;
	}

}

class Main {
	static int N, M, T, answer;
	static int[][] map;

	public static int bfs(int startX, int startY, int endX, int endY, boolean hasBomb) {
		int answer = T+1;
		Deque<Node> q = new ArrayDeque<>();
		q.add(new Node(startX, startY, 0, hasBomb));
		boolean[][] visited = new boolean[N][M];
		visited[startY][startX] = true;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		while (!q.isEmpty()) {
			Node cur = q.pop();
			if (cur.y == endY && cur.x == endX) {
				answer = Math.min(answer, cur.dist);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx]) {
					if (cur.hasBomb && map[ny][nx] == 1) {
						visited[ny][nx] = true;
						q.add(new Node(nx, ny, cur.dist + 1, cur.hasBomb));
						continue;
					}

					if (map[ny][nx] != 1) {
						visited[ny][nx] = true;
						q.add(new Node(nx, ny, cur.dist + 1, cur.hasBomb));
					}

				}
			}
		}
		return answer;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int bombX = M - 1, bombY = N - 1;

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					bombY = i;
					bombX = j;
				}
			}
		}

		int to_bomb = bfs(0, 0, bombX, bombY, false);
		int not_use_bomb = bfs(0, 0, M - 1, N - 1, false);

		if (not_use_bomb < to_bomb) {
			answer = not_use_bomb;
		} else {
			int bomb_to_end = bfs(bombX, bombY, M - 1, N - 1, true);
			answer = Math.min(not_use_bomb, to_bomb + bomb_to_end);
		}

		if (answer <= T) {
			bw.write(answer + "\n");
		} else {
			bw.write("Fail\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
