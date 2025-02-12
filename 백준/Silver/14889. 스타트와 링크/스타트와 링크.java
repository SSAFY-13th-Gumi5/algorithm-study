import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] selected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
	}
	static void dfs(int depth, int index) {
		if (depth == N / 2) {
			caculate();
			return ;
		}
		
		for (int i = index; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(depth + 1, i + 1);
				selected[i] = false;
			}
		}
	}
	
	static void caculate() {
		int Steam = 0;
		int Lteam = 0;
		
		for (int i =0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				if (selected[i] && selected[k]) {
					Steam += map[i][k];
				} else if (!selected[i] && !selected[k])
					Lteam += map[i][k];
			}
		}
		int diff = Math.abs(Steam - Lteam);
		min = Math.min(min, diff);
	}
}
