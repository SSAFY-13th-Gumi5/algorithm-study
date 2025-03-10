import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static List<Point> house;
	static List<Point> chicken;
	static boolean selected[];
	static int result = Integer.MAX_VALUE;
	
	public static class Point {
		int x,y;
		
		Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
		
		int distance(Point other) {
			return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				
				if (map[i][k] == 1) {
					house.add(new Point(i, k));
				} else if (map[i][k] == 2) {
					chicken.add(new Point(i, k));
				}
			}
		}
		selected = new boolean[chicken.size()];
		
		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int start, int cnt) {
		// TODO Auto-generated method stub
		if (cnt == M) {
			result = Math.min(result, checkDistance());
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(i + 1, cnt + 1);
				selected[i] = false;
			}
		}
	}

	private static int checkDistance() {
		// TODO Auto-generated method stub
		int total = 0;
		
		for (Point house : house) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < chicken.size(); i++) {
				if (selected[i]) {
					min = Math.min(min, house.distance(chicken.get(i)));
				}
			}
			total += min;
		}
		
		return total;
	} 
}
