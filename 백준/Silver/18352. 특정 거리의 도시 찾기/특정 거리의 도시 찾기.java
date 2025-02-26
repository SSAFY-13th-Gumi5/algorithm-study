import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList [N + 1];
		
		for (int i =0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		int[] distance = new int[N + 1];
		Arrays.fill(distance, -1);
		distance[X] = 0;
		
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.add(X);
		
		while (!deque.isEmpty()) {
			int current  = deque.poll();
			
			for (int next : graph[current]) {
				if (distance[next] == -1) {
					distance[next] = distance[current] + 1;
					deque.add(next);
				}
			}
		}
		
		boolean flag = false;
		
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K) {
				sb.append(i + "\n");
				flag = true;
			}
		}
		if (flag) {
			System.out.println(sb);
			return;
		}
		System.out.println(-1);
	}

}
