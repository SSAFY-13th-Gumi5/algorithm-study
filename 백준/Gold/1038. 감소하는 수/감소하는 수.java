import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Long> list;
	static int numbers[] =  new int[10];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//최대 감소하는 수 : 9876543210
		int N = Integer.parseInt(st.nextToken());
		if(N >= 1023) {
			System.out.println(-1);
			return;
		}
		list = new ArrayList<>();
		for(int i =0; i <= 10; i ++) {
			조합(0,0,i);
		}
		Collections.sort(list);

		System.out.println(list.get(N+1));
	}

	private static void 조합(int cnt,int start ,int target) {
		if(cnt == target) {
			String s = "";
			for(int i = 9; i >= 0; i --) {
				if(numbers[i] == 1)
					s += i;
			}
			if(!s.equals(""))
				list.add(Long.parseLong(s));
			else {
				list.add(0L);
			}
			return;
		}
		for(int i = start; i < 10; i ++) {
			numbers[i] = 1;
			조합(cnt+1,i+1,target);
			numbers[i] = 0;
		}
		
	}
}