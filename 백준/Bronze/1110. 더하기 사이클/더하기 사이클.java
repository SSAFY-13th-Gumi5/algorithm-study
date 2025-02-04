import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int n = N;
		int answer = 0;

		while (true) {
			int a, b;
			a = n / 10;
			b = n % 10;
			n = 10 * b + (a + b) % 10;
			answer += 1;
			if (n == N)
				break;
		}

		System.out.println(answer);

	}

}