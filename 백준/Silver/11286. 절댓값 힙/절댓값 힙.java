import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o2) == Math.abs(o1)) {
					return o1 - o2;
				} else {
					return Math.abs(o1) - Math.abs(o2);
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(bf.readLine());
			if (a == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else {
				queue.add(a);
			}
		}

		System.out.println(sb.toString());
	}

}