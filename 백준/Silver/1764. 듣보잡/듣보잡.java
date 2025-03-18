import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String > set = new HashSet<String>();
		ArrayList<String >arr = new ArrayList<String>();
		for(int i =0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			set.add(st.nextToken());
		}
		int count =0;
		for(int i =0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(set.contains(s)) {
				count ++;
				arr.add(s);
			}
			
		}
		System.out.println(count);
		Collections.sort(arr);
		for(int i=0; i < arr.size(); i ++) {
			System.out.println(arr.get(i));
		}
	}
}