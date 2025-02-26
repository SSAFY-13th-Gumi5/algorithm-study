import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static HashSet<Character> set = new HashSet<Character>();
	static int result = 1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		set.add(map[0][0]);
		dfs(0, 0, 1);
		System.out.println(result);
	}

	private static void dfs(int x, int y, int cnt) {
		// TODO Auto-generated method stub
		result = Math.max(result, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < C && ny >= 0 && ny <R &&! set.contains(map[ny][nx])) {
				set.add(map[ny][nx]);
				dfs(nx, ny, cnt + 1);
				set.remove(map[ny][nx]);
			}
		}
	}

}
