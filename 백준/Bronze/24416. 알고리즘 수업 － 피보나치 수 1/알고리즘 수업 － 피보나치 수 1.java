import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt1 = 0;
	static int cnt2 = 0;
	static int[] dp = new int[100];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		fib(n);
		fibonacci(n);
		
		System.out.println(cnt1 + " " + cnt2);

	}
	public static int fib(int n) {
		if (n ==1 || n == 2) {
			cnt1++;
			return 1;
		} else {
			return (fib(n - 1) + fib (n - 2));
		}
	}
	public static int fibonacci(int n) {
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i =2; i < n; i++) {
			cnt2++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return (dp[n - 1]);
	}

}
