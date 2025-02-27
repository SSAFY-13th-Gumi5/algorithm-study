import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	String str;
	int mod;

	public Node(String str, int mod) {
		this.str = str;
		this.mod = mod;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, N;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			String answer = bfs(N);
			bw.write(answer+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

	private static String bfs(int n) {

		Deque<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		q.add(new Node("1", 1 % n));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(visited[cur.mod])
				continue;
			
			visited[cur.mod] = true;
			if (cur.mod == 0) {
				return cur.str;
			}

			if (cur.str.length() < 100) {
				q.add(new Node(cur.str + "1", (cur.mod * 10 + 1) % n));
				q.add(new Node(cur.str + "0", (cur.mod * 10) % n));
			}

		}

		return "BRAK";

	}
}