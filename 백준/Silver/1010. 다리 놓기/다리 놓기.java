import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	
    public static void main(String args[])throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine()); 
        
        for(int i=0;i<T;i++) {
        	String[] s = br.readLine().split(" ");
        	int N = Integer.parseInt(s[0]);
        	int M = Integer.parseInt(s[1]);
        	
        	bw.write(combination(M, N) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int combination(int n, int m) {
    	
    	if(n==m||m==0) {
    		return 1;
    	}
    	
    	if(dp[n][m] > 0) {
    		return dp[n][m];
    	}
    		
    	dp[n][m] = combination(n-1, m-1)+combination(n-1, m);
    	return dp[n][m];
    }

}