import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.management.Query;
import javax.naming.spi.DirStateFactory.Result;

public class Main {
	static int[][] map;
	static boolean[][][] visit;
	static int n, m, t;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m][2]; //그람을 먹은 세상, 안 먹은 세상을 분리해준다.
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k =0; k < m; k++) {
				String num = st.nextToken();
				if (num.equals("1")) {
 					map[i][k] = 1;
				}
				else if (num.equals("2")) {
					map[i][k] = 2;
				}
			}
		}
		int result = bfs(0, 0);
		System.out.println(result == -1 ? "Fail" : result);
	}
	public static int bfs(int sx, int sy) {
		Deque<int[]> deque = new LinkedList<int[]>();
		deque.add(new int[] {sx, sy, 0, 0});
		visit[0][0][0] = true;
		
		while (!deque.isEmpty()) {
			int[] d = deque.poll();
			int y = d[0];
			int x = d[1];
			int time = d[2];
			int gram = d[3];
			
			if (y == n -1 && x == m - 1) {
				return (time);
			}
			
			if (time > t)
				return -1;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				
				if (gram == 1 && !visit[ny][nx][1]) {
					deque.add(new int[] {ny, nx, time + 1, 1});
					visit[ny][nx][1] = true;
				}
				
				if (gram == 0 && !visit[ny][nx][0] && map[ny][nx] != 1) {
					int isGram = (map[ny][nx] == 2) ? 1 : 0;
					deque.add(new int[] {ny, nx, time + 1, isGram});
					visit[ny][nx][0] = true;
				}
			}
			
		}
		
		return -1;
	}
}
