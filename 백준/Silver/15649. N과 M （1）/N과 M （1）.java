import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static List<Boolean> visited;
	private static Deque<Integer> stack = new ArrayDeque();

	public static void dfs(int idx, int depth) throws IOException {
		if (depth == M) {
			Iterator<Integer> iter = stack.iterator();

			while (iter.hasNext())
				bw.write(iter.next() + " ");
			bw.newLine();
		}
		for (int i = 1; i <= N; i++) {
			if (!visited.get(i)) {
				visited.set(i, true);
				stack.add(i);
				dfs(i, depth+1);
				visited.set(i, false);
				stack.pollLast();
			}
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		visited = new ArrayList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		visited.add(false);
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
			visited.add(false);
		}

		dfs(1, 0);
	

		bw.flush();
		bw.close();
		br.close();

	}

}