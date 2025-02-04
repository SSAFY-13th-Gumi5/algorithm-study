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

	public static void main(String[] args) throws IOException {
		char[][] arr = new char[5][15];
		int maxLength = 1;
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			maxLength = Math.max(maxLength, str.length());
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int j = 0; j < maxLength; j++) {
			for (int i = 0; i < 5; i++) {
				if (arr[i][j] != 0)
					bw.write(arr[i][j]);
			}
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
