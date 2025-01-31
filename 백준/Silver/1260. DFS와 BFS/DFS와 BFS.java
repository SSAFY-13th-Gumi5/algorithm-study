import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken()); // 정점
		int M = Integer.parseInt(st.nextToken()); // 간선
		int V = Integer.parseInt(st.nextToken()); // 시작점
		
		LinkedList[] list = new LinkedList[N+1];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new LinkedList<>();
			visited[i] = false;
		}
		
		for (int i=0; i < M; i++) {
			String node = bf.readLine();
			StringTokenizer st2 = new StringTokenizer(node);
			int ver = Integer.parseInt(st2.nextToken()); // 정점
			int ver2 = Integer.parseInt(st2.nextToken()); // 정점2
			list[ver].add(ver2);
			list[ver2].add(ver);
		}
		
		DFS(list, visited, V);
		System.out.println();
		BFS(list, V);
	}

	public static void DFS(LinkedList[] list, boolean[] visited, int v) {
		if (!visited[v]) {
			System.out.print(v + " ");
			visited[v] = true;
		}
		
		for (int i = 0; i < list[v].size(); i++) {
			Collections.sort(list[v]);
			int next = (int) list[v].get(i);
			if (!visited[next]) {
				DFS(list, visited, next);
			}
		}
	}
	
	public static void BFS(LinkedList[] list, int v) {
		boolean[] visited = new boolean[list.length];
		
		for (int i = 0; i < list.length; i++) {
			visited[i] = false;
		}
		
		Queue queue = new LinkedList<>();
		int cur = v;
		int next = 0;
		
		queue.add(cur);
		visited[cur] = true;
		
		while(!queue.isEmpty()) {
			cur = (int) queue.remove();
			System.out.print(cur + " ");
			
			for (int i = 0; i< list[cur].size(); i++) {
				next = (int) list[cur].get(i);
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
