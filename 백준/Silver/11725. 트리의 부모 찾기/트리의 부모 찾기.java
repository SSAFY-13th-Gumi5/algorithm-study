import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int n = Integer.parseInt(br.readLine());
		int[] result = new int[n + 1];
		
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		
		for (int i =1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		boolean[] visit = new boolean[n + 1];
		StringTokenizer st;
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		Deque<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			
			for (int next : arr[q]) {
				if (visit[next])
					continue;
				visit[next] = true;
				queue.add(next);
				result[next] = q;
			}
		}
		for (int i = 2; i<=n; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
