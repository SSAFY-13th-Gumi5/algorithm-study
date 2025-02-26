import java.io.*;
import java.util.*;

public class Main {
	private static int N, M, K, V; // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
	private static List<Integer>[] city;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().trim().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		V = Integer.parseInt(input[3]);

		city = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			city[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			city[s].add(e);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(city[i]);
		}

		bfs(V);

		if (sb.length() > 0) {
			bw.write(sb.toString());
		} else {
			bw.write("-1\n");
		}

		bw.flush();
		br.close();
		bw.close();
	}

	private static void bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int depth = 0;

		visited[start] = true;
		queue.offer(start);
		while (!queue.isEmpty()) {

			int size = queue.size();
			// 목표 거리 K에 도달하면 큐에 있는 모든 도시를 출력하고 종료
			if (depth == K) {
				List<Integer> result = new ArrayList<>();
				while (!queue.isEmpty()) {
					result.add(queue.poll());
				}
				Collections.sort(result); // 작은 숫자부터 출력되도록 정렬
				for (int city : result) {
					sb.append(city + "\n");
				}
				return;
			}

			// 다음 깊이 탐색
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				for (int next : city[current]) {
					if (!visited[next]) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
			depth++;
		}
	}
}