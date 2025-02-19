import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int R;
	static int C;
	static char[][] map;
	static int answer = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[] alpha = new boolean['a' - 'A'];

	private static void dfs(int x, int y, int depth) {
		answer = Math.max(answer, depth);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && ny >= 0 && ny < R && nx < C) { // index 범위 체크
				if (!alpha[map[ny][nx] - 'A']) { //이미 방문했거나 이미 사용한 문자가 있는 곳이 아닌 경우
					
					alpha[map[ny][nx] - 'A'] = true;
					dfs(nx, ny, depth + 1);
					alpha[map[ny][nx] - 'A'] = false;
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		answer = 0;
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		bw.write(answer+"\n");
		bw.flush();
		br.close();
		bw.close();
	}

}