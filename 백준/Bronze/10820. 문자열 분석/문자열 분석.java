import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while ((str = br.readLine()) != null && !(str.isEmpty())) {
			int[] result = new int[4];
			char[] ch = str.toCharArray();
			for (char c: ch) {
				if (Character.isLowerCase(c))
					result[0]++;
				else if (Character.isUpperCase(c))
					result[1]++;
				else if (Character.isDigit(c))
					result[2]++;
				else if (Character.isWhitespace(c))
					result[3]++;
			}
			System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		}
	}

}
