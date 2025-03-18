import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] population;
	static List<Integer>[] graph;
	static int answer = Integer.MAX_VALUE;
	static int[] district; // 0 또는 1로 선거구 분할

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		population = new int[N + 1];
		graph = new ArrayList[N + 1];
		district = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			int edgeCount = sc.nextInt();
			for (int j = 0; j < edgeCount; j++) {
				int neighbor = sc.nextInt();
				graph[i].add(neighbor);
			}
		}

		sc.close();
		dfs(1);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	private static void dfs(int node) {
		if (node > N) {
			if (isValidPartition()) {
				int sumA = 0, sumB = 0;
				for (int i = 1; i <= N; i++) {
					if (district[i] == 1)
						sumA += population[i];
					else
						sumB += population[i];
				}
				answer = Math.min(answer, Math.abs(sumA - sumB));
			}
			return;
		}

		// 현재 노드를 그룹 A(1)로 할당
		district[node] = 1;
		dfs(node + 1);

		// 현재 노드를 그룹 B(0)로 할당
		district[node] = 0;
		dfs(node + 1);
	}

	private static boolean isValidPartition() {
		boolean[] visited = new boolean[N + 1];
		int firstA = -1, firstB = -1;

		for (int i = 1; i <= N; i++) {
			if (district[i] == 1 && firstA == -1)
				firstA = i;
			if (district[i] == 0 && firstB == -1)
				firstB = i;
		}

		if (firstA == -1 || firstB == -1)
			return false; // 한 쪽이 비어 있으면 불가능

		// 두 구역이 각각 연결된 그래프인지 확인
		bfs(firstA, 1, visited);
		bfs(firstB, 0, visited);

		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void bfs(int start, int type, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbor : graph[node]) {
				if (!visited[neighbor] && district[neighbor] == type) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
}