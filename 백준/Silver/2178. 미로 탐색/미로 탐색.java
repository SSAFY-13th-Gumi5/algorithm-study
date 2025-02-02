import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visit;
	static int[] dx = {-1,  1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int k = 0; k < m; k++) {
				map[i][k] = str.charAt(k) - '0';
			}
		}
		
		visit = new boolean[n][m];
		visit[0][0] = true;
		
		bfs(0, 0);
		System.out.println(map[n - 1][m -1]);
	}
	public static void bfs(int y, int x) {
		Deque<int[]> deque = new LinkedList<int[]>();
		
		deque.add(new int[] {y,x});
		
		while (!deque.isEmpty()) {
			int point[] = deque.poll();
			int by = point[0];
			int bx = point[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = by + dy[i];
				int nx = bx + dx[i];
				
				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (visit[ny][nx] == false && map[ny][nx] == 1) {
						deque.add(new int[] {ny, nx});
						map[ny][nx] = map[by][bx] + 1;
						visit[ny][nx] = true;
					}
				}

			}
		}
	}
}
