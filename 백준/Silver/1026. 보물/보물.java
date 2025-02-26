import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int[] B;
	static Map<Integer, Integer> temp;
	static int S;
	
	//TreeMap 대신 Pair 클래스 생성	
	public static class Pair implements Comparable<Pair> {
		int value;  //비교값
		int index;  
		
		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		//두 정수 비교, Pair 객체들은 value값 기준으로 오름차순 정렬 
		@Override
		public int compareTo(Pair other)
		{
			return Integer.compare(this.value, other.value);
			}
		}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		// 배열 A 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
	
		// 배열 B 생성
		Pair [] bArr = new Pair[N];
		StringTokenizer ts = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(ts.nextToken());
			bArr[i] = new Pair(B[i], i);
		}
		
		
		//bArr를 정렬하면, value 값(B의 값)에 따라 오름차순으로 정렬됨
		Arrays.sort(bArr);
		
		int[] newA = new int[N];
		
		for(int i = 0; i < N; i++) {
			newA[bArr[i].index] = A[N-1-i];
		}
		
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += newA[i] * B[i];
		}

		bw.write(S + "");
		bw.flush();
		br.close();
		bw.close();
	}

}