import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int R = input[0];
		int C = input[1];
		int answer = 1;
		int[][] map = new int[R][C];

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < R; i++) {
			String line = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int nx, ny;
				if (map[i][j] == 'W') {
					for (int d = 0; d < 4; d++) {
						ny = i + dy[d];
						nx = j + dx[d];
						if (nx >= 0 && ny >= 0 && nx < C && ny < R && map[ny][nx] == 'S') {
							bw.write("0\n");
							bw.flush();
							bw.close();
							bf.close();
							return;
						}
					}
				}
			}
		}
		
		bw.write("1\n");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.')
					bw.write("D");
				else
					bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
