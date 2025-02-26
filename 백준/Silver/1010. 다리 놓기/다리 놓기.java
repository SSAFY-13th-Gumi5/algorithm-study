import java.io.*;

public class Main {
	private static int N, M;

	private static long combination(int m, int n) {
		if( n == 0 || n == m) return 1;
		if( n == 1) return m;
		
		long result = 1;
		for(int i = 0; i < n; i++) {
			result *= (m-i);  // 분자 M*(M-1)*(M-2)*(M-3).....*(M-N+1)
			result /= (i+1);  // 분모 N! (N 팩토리얼을 나누는 과정) 
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] input = br.readLine().trim().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			sb.append(combination(M,N)+ "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}