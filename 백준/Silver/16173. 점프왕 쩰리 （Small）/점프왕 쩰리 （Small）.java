import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean isfind;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i =0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(isfind ? "HaruHaru" : "Hing");
	}
	
	private static void dfs(int y, int x) {
		if (x < 0 || y < 0 || x >= N || y >= N || visited[y][x] || isfind) {
			return;
		}
		
		if (map[y][x] == -1) {
			isfind = true;
			return;
		}
		
		visited[y][x] = true;
		int move = map[y][x];
		dfs(y + move,x);
		dfs(y, x + move);
	}

}