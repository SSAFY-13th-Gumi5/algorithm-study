import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] A;
	static int[][] B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		A = new int[n][m];
		B = new int[n][m];
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int k = 0; k < m; k++) {
				A[i][k] = str.charAt(k) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int k = 0; k < m; k++) {
				B[i][k] = str.charAt(k) - '0';
			}
		}
		
		for (int i =0; i < n -2; i++) {
			for (int k = 0; k < m - 2; k++) {
				if (A[i][k] != B[i][k]) {
					result++;
					myFun(i, k);
				}
			}
		}
		
		for (int i =0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				if (A[i][k] != B[i][k]) {
					System.out.println("-1\n");
					return;
				}
			}
		}
		System.out.println(result);
	}
	public static void myFun(int i, int k) {
		for (int f = i; f < i+3; f++) {
			for (int s = k; s < k + 3; s++) {
				A[f][s] = A[f][s] == 1 ? 0 : 1;
			}
		}
	}
}
