import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int[] alpha = new int[26];
		
		for (char c : str.toCharArray()) {
			alpha[c - 'A']++;
		}
		
		int check = 0;
		char mid = '\0';
		
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 == 1) {
				check++;
				mid = (char) (i + 'A');
			}
		}
		
		if (check > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		for (int i = 0; i < 26; i++) {
			for (int k = 0; k < alpha[i] / 2; k++) {
				sb.append((char) (i + 'A'));
			}
		}
		
		StringBuilder sb2 = new StringBuilder(sb);
		if (mid != '\0')
			sb2.append(mid);
		
		sb2.append(sb.reverse());
		System.out.println(sb2);
	}

}
