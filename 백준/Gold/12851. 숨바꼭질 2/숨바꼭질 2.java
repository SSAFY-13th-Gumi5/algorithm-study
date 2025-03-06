import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, MAX=100000;
	static boolean[] visited;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[MAX+1];
		queue = new ArrayDeque<Integer>();
		queue.offer(N);
		
		int time = 0;
		while(true) {
			int cnt = bfs();
			if(cnt>0) {
				System.out.println(time);
				System.out.println(cnt);
				break;
			}
			time++;
		}
	}
	
	private static int bfs() {
		int cnt = 0;
		int size=queue.size();
		for (int i = 0; i < size; i++) {
			int cur = queue.poll();
			visited[cur]=true;
			
			if(cur==K) {
				cnt++;
				continue;
			}
			
			if(cur*2 <= MAX && !visited[cur*2]) queue.offer(cur*2);
			if(cur+1 <= MAX && !visited[cur+1]) queue.offer(cur+1);
			if(cur-1 >= 0 && !visited[cur-1]) queue.offer(cur-1);
		}
		return cnt;
	}
}