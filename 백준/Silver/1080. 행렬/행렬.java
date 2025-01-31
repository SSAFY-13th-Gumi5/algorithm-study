import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static boolean checkAll(boolean[][] arr1, boolean[][] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				if (arr1[i][j] != arr2[i][j])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N, M;
		String[] line = bf.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		boolean[][] matrix1 = new boolean[N][M];
		boolean[][] matrix2 = new boolean[N][M];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			String row = bf.readLine();
			for (int j = 0; j < M; j++) {
				matrix1[i][j] = row.charAt(j) == '1' ? true : false;
			}
		}
		for (int i = 0; i < N; i++) {
			String row = bf.readLine();
			for (int j = 0; j < M; j++) {
				matrix2[i][j] = row.charAt(j) == '1' ? true : false;
			}
		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					answer += 1;
					for (int y = 0; y <= 2; y++) {
						for (int x = 0; x <= 2; x++) {
							matrix1[i + y][j + x] = !matrix1[i + y][j + x];
						}
					}
				}
			}
		}

		if (!checkAll(matrix1, matrix2)) {
			answer = -1;
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		bf.close();

	}

}
