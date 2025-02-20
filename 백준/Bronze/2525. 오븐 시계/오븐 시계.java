import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int input = Integer.parseInt(br.readLine());
		
		int tmp = B + input;
		A += (tmp) / 60;
		B = (tmp) % 60;
		if (A >= 24) {
			A = A % 24;
		}
		System.out.println(A + " " + B);
	}

}
