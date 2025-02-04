import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for (int i = 1; i <= N; i++)
			graph.put(i, new ArrayList<>());

		boolean[] visitB = new boolean[N + 1];
		boolean[] visitD = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
			Collections.sort(entry.getValue());
		}

		DFS(graph, V, visitD, sb);
		sb.append("\n");
		BFS(graph, V, visitB, sb);

		System.out.println(sb);
	}

	public static void DFS(Map<Integer, ArrayList<Integer>> graph, int node, boolean[] visited, StringBuilder sb) {
		if (visited[node])
			return;
		else {
			visited[node] = true;
			sb.append(node).append(" ");
		}

		for (int adjNode : graph.get(node))
			DFS(graph, adjNode, visited, sb);
	}

	public static void BFS(Map<Integer, ArrayList<Integer>> graph, int node, boolean[] visited, StringBuilder sb) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node] = true;

		while (!q.isEmpty()) {
			int curNode = q.remove();
			sb.append(curNode).append(" ");

			for (int adjNode : graph.get(curNode)) {
				if (!visited[adjNode]) {
					q.add(adjNode);
					visited[adjNode] = true;
				}
			}
		}
	}
}