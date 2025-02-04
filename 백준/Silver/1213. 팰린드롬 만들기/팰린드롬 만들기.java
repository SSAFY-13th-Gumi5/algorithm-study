import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		List<Character> answer = new ArrayList<>();
		int[] arr = new int['a' - 'A'];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}

		char mid = 0;
		boolean flag = true;
		L: for (int i = 0; i < 'a' - 'A'; i++) {
			if (arr[i] % 2 == 1) {
				if (mid != 0) {
					// 홀수가 2개 이상이다? 쏘리~
					flag = false;
					break L;
				}
				mid = (char) ('A' + i);
			}
			for (int j = 0; j < arr[i] / 2; j++) {
				answer.add((char) ('A' + i));
			}
		}

		// 출력
		if (flag) {
			for (int i = 0; i < answer.size(); i++) {
				bw.write(answer.get(i));
			}
			if (mid != 0) {
				bw.write(mid);
			}
			for (int i = answer.size() - 1; i >= 0; i--) {
				bw.write(answer.get(i));
			}
		} else {
			bw.write("I'm Sorry Hansoo");
		}

		bw.newLine();
		bw.flush();
		bw.close();
		br.close();

	}
}
