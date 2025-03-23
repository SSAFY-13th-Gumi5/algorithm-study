import java.io.*;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;

	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static Node company;
	static Node house;
	static Node[] customers;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			customers = new Node[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			house = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < n; i++) {
				customers[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = Integer.MAX_VALUE;
			makePermutation(n, 0, new Node[n], new boolean[n], 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.print(sb);

		br.close();
	}

	private static void makePermutation(int n, int cnt, Node[] order, boolean[] visited, int distance) {
		if (distance > min)
			return;

		if (cnt == n) {
			int result = distance + Math.abs(company.y - order[n - 1].y) + Math.abs(company.x - order[n - 1].x);
			min = Math.min(result, min);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			order[cnt] = customers[i];
			if (cnt == 0)
				makePermutation(n, cnt + 1, order, visited,
						distance + Math.abs(house.y - order[cnt].y) + Math.abs(house.x - order[cnt].x));
			else
				makePermutation(n, cnt + 1, order, visited, distance + Math.abs(order[cnt - 1].y - order[cnt].y)
						+ Math.abs(order[cnt - 1].x - order[cnt].x));
			visited[i] = false;
		}

	}
}