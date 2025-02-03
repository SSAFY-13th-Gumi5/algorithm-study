import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char arr[][] = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int k = 0; k < str.length(); k++) {
				arr[i][k] = str.charAt(k);
			}
		}
		
		for (int k = 0; k < arr[0].length; k++) {
			for (int i =0; i < 5; i++) {
				if (arr[i][k] == 0)
					continue;
				sb.append(arr[i][k]);
			}
		}
		System.out.println(sb);
	}

}
