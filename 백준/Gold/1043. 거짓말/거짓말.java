import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int parents[];
	static void make() {
		for(int i =0; i < N; i ++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a] ==a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}
	static ArrayList<Integer> liar;
	static ArrayList<Integer>[] party;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result =0;
		N = Integer.parseInt(st.nextToken());
		parents = new int[N];
		make();
		liar = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		party = new ArrayList[M];
		for(int i =0; i < M; i ++) {
			party[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int j =0; j < K; j++) {
			liar.add(Integer.parseInt(st.nextToken())-1);
		}
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j =0; j < temp; j++) {
				party[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		for(int i =0; i < M; i++) {
			if(party[i].size() >= 2) {
				for(int j =0; j < party[i].size()-1; j ++) {
					union(party[i].get(j),party[i].get(j+1));
				}
			}
		}
		for(int i =0; i <liar.size(); i ++) {
			if(!liar.contains(parents[liar.get(i)]))
				liar.add(parents[liar.get(i)]);
		}
		for(int i =0; i < M; i++) {
			int cnt =0;
			for(int j =0; j < party[i].size(); j ++) {
				if(!liar.contains(findSet(party[i].get(j))))
					continue;
				cnt ++;
			}
			if(cnt ==0)
				result ++;
		}
		System.out.println(result);
	}
}