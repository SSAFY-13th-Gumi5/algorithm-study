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

		int N, answer = 0;
		N = Integer.parseInt(bf.readLine());
		int[] R = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int[] answers = new int[N+1];
		for(int i=1;i<=N;i++) {
			answers[i] = R[i-1] + answers[i-1]; 
		}
		bw.write(Arrays.stream(answers).sum()+"\n");
		bw.flush();
		bw.close();
		bf.close();
	}
}
