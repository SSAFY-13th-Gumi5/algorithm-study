import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[10001];

		int N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr[num] += 1;
		}

		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < arr[i]; j++)
				bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}
