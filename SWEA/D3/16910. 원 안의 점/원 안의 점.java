
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			for(int i = -N; i <= N; i++) { 
				for(int j = -N; j <= N; j++) {
					if( i*i + j*j <= N*N) count++;
				}
			}
			System.out.println("#"+t+" "+ count);
		}
	}
}