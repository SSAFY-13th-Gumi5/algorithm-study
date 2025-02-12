import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] operators = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		
		for (int i =0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int sum, int index) {
		if (index == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				
				if (i == 0)
					dfs(sum + arr[index], index + 1);
				else if (i == 1)
					dfs(sum - arr[index], index + 1);
				else if (i == 2)
					dfs(sum * arr[index], index + 1);
				else if (i == 3)
					dfs(sum / arr[index], index + 1);
				operators[i]++;
			}
		}
	}

}
