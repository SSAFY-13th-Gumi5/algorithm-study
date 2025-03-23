import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main { 
	static int N, M;
	static int[] parents;
	static boolean[] knowsTruth; // 진실을 아는 사람

	public static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		
		return (parents[a] = findSet(parents[a]));
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int [N + 1];
		knowsTruth = new boolean[N + 1];
		makeSet();
		
		st = new StringTokenizer(br.readLine());
		
		int truethCount = Integer.parseInt(st.nextToken());
		
		int firstTrue = -1;
		if (truethCount > 0) {
			firstTrue = Integer.parseInt(st.nextToken());
			knowsTruth[firstTrue] = true;
		}
		
		/***
		 * 첫번째 진실을 아는 사람으로 union을 통해 다 연결
		 */
		for (int i = 1; i < truethCount; i++) {
			int person = Integer.parseInt(st.nextToken());
			knowsTruth[person] = true;
			union(firstTrue, person);
		}
		
		List<int[]> parties = new ArrayList<>();
		
		/**
		 * 파티의 정보를 입력 받기
		 */
		for (int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			int[] party = new int[partySize];
			
			if (partySize > 0) {
				party[0] = Integer.parseInt(st.nextToken()); //루트가 될 사람
				for (int k = 1; k < partySize; k++ ) {
					party[k] = Integer.parseInt(st.nextToken());
					union(party[0], party[k]);
				}
			}
			parties.add(party);
		}
		
		Set<Integer> result = new HashSet<>();
		
		for (int i =1; i <= N; i++) {
			if(knowsTruth[i]) {
				result.add(findSet(i)); // 진실을 아는 사람의 루트를 추가한다
			}
		}
		
		int count = 0;
		for (int[] party : parties) {
			boolean flag = true;
			for (int person : party) {
				// 해당 파티에 진실을 아는 사람이 있으면 거짓말 못함
				if (result.contains(findSet(person))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		System.out.println(count);
	}
}
