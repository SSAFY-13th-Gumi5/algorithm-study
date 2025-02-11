import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[D + 1];
		for (int i =0; i <= D; i++) {
			dp[i] = i;
		}
		
		ArrayList<int[]> arr = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			if (end > D || end - start <= length)
				continue;
			arr.add(new int[] {start, end, length});
		}
		
		for (int i = 0; i <= D; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			}
			
			for (int[] shot : arr) {
				int start = shot[0];
				int end = shot[1];
				int length = shot[2];
				
				if (i == start) {
					dp[end] = Math.min(dp[end], dp[start] + length);
				}
			}
		}
		System.out.println(dp[D]);
	}

}
