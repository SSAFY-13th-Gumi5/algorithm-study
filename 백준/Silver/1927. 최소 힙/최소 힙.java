import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0 && pq.isEmpty()) {
				sb.append(0 + "\n");
			} else if (num == 0 && !pq.isEmpty()) {
				sb.append(pq.poll() + "\n");
			} else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}

}