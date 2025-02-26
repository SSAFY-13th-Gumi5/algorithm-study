import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().trim().split(" ");
		N = Integer.parseInt(input[0]); // 듣도 못한 사람의 수 
		M = Integer.parseInt(input[1]); // 보도 못한 사람의 수 
		
		Set<String> unheard = new HashSet<>(); //unheard
		for (int i = 0; i < N; i++) {
			String name1 = br.readLine();
			unheard.add(name1);
		}
		
		List<String> unhs = new ArrayList<>(); //unheard_unseen
		for(int i = 0; i <M; i++) {
			String name2 = br.readLine();
			if(unheard.contains(name2)) {
				unhs.add(name2);
			}
		}
		
		Collections.sort(unhs);
		
		int size = unhs.size();
		sb.append(size+"\n");
		for(String name : unhs) {
			sb.append(name+"\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}