import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int A, B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	private static long bfs() {
		// TODO Auto-generated method stub
		Deque<long[]> deque = new ArrayDeque<long[]>();
		
		deque.offer(new long[] {A,1});
		while (!deque.isEmpty()) {
			long[] current = deque.pollFirst();
			long n = current[0];
			long count = current[1];
			
			if (n == B) {
				return (count);
			}
			
			if (n * 2 <= B) {
				deque.offer(new long[] {n * 2, count + 1});
			}
			if (n * 10 + 1 <= B) {
				deque.offer(new long[] {n * 10 + 1, count + 1});
			}
		}
		return (-1);
	}

}
