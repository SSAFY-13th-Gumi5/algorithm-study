import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			int n = Integer.parseInt(br.readLine());
			int[]arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int tmp = 0;
			int result = 0;
			
			for (int i = 0; i < n; i++) {
				tmp += arr[i];
				result += tmp;
			}
			System.out.println(result);
		}
}
