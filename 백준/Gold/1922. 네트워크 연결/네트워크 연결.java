import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int v;
	int e;

	public Edge(int v, int e) {
		this.v = v;
		this.e = e;
	}

	@Override
	public int compareTo(Edge o) {
		return this.e - o.e;
	}
}

class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int N, M;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int answer = 0;
		List<List<Edge>> graph = new ArrayList<>();
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int from, to, edge;
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Edge(to, edge));
			graph.get(to).add(new Edge(from, edge));
		}

		visited[1] = true;
		for (int i = 0; i < graph.get(1).size(); i++) {
			pq.add(graph.get(1).get(i));
		}
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int to = cur.v;
			int cost = cur.e;

			if (!visited[to]) {
				visited[to] = true;
				answer += cost;
				for (int i = 0; i < graph.get(to).size(); i++) {
					pq.add(graph.get(to).get(i));
				}
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
