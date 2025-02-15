import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			
			int last = input.charAt(input.length() - 1);
			if (last % 2 == 0) {
				sb.append("#" + tc + " " + "Even" + "\n");
			} else {
				sb.append("#" + tc + " " + "Odd" + "\n");
			}
		}
		System.out.println(sb);
	}

}
