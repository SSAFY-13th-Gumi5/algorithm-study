import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;
		T = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(bf.readLine());
			int[][] dp = new int[3][n+1];
			String[] line1 = bf.readLine().split(" ");
			String[] line2 = bf.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				dp[1][j] = Integer.parseInt(line1[j-1]);
				dp[2][j] = Integer.parseInt(line2[j-1]);
				
				dp[0][j] = Math.max(Math.max(dp[0][j-1], dp[1][j-1]), dp[2][j-1]);
				dp[1][j] = Math.max(dp[0][j-1] + dp[1][j], dp[2][j-1] + dp[1][j]);
				dp[2][j]  = Math.max(dp[0][j-1] + dp[2][j], dp[1][j-1] + dp[2][j]);
				
			}
			bw.write(Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n])+"\n");
		}
		bw.flush();
		bw.close();
		bf.close();
	}
}
