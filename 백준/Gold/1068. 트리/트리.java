
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int root = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == -1) {
				root = i;
				continue;
			}
			list[arr[i]].add(i);
		}
		if (root == M) {
			System.out.println(0);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		int cnt =0;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			int childCount =0;
			
			for(int i =0; i < list[n].size(); i ++) {
				int temp = list[n].get(i);
				if(temp == M)
					continue;
				q.add(temp);
				childCount ++;
			}
			if(childCount ==0)
				cnt ++;
		}
		System.out.println(cnt);

	}
}
