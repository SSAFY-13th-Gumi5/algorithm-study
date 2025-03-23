import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean visited[];
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		visited[1] = true;
		
		while (!queue.isEmpty()) {
			int q = queue.poll();
			for (int next : graph[q]) {
				if (!visited[next]) {
					result++;
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		
	}
}