import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	private static class Pair implements Comparable<Pair> {
		int start, end;

		public Pair(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Pair o) {
			if (end == o.end)
				return start - o.start;
			return end - o.end;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return start + " " + end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			list.add(new Pair(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}

		Collections.sort(list);
		int answer = 0;
		int tmp = -1;
		for(Pair p :list) {
			if(tmp <= p.start) {
				tmp = p.end;
				answer+=1;
			}
		}
		System.out.println(answer);
	}

}