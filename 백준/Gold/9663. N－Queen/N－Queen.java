import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int N;
	private static int answer;
	private static List<Boolean> visited;
	private static int[] board = new int[15];

	public static boolean check(int depth) {
		for (int i = 0; i < depth; i++) {
			if (board[i] == board[depth])
				return false;
			if (Math.abs(i - depth) == Math.abs(board[i] - board[depth]))
				return false;
		}
		return true;

	}

	public static void dfs(int depth) {
		if (depth == N) {
//			for (int i = 0; i < N; i++)
//				System.out.print(board[i]);
//			System.out.println();
			answer += 1;
			return;
		}

		for (int i = 0; i < N; i++) {
			board[depth] = i;
			if (check(depth))
				dfs(depth + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		answer = 0;
		N = Integer.parseInt(br.readLine());
		visited = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			board[i] = 0;
			visited.add(false);
		}

		dfs(0);
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}