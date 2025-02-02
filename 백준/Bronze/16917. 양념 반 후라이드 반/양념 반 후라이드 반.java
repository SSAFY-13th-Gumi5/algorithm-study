import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        long result = 0;
        
        int cnt = Math.min(X,Y);
        
        if (2 * C < A+B) {
        	result = 2 * C * cnt;
        } else {
        	result = (A + B) * cnt;
        }
        
        if (cnt == X) {
        	cnt = Y - cnt;
        	result += Math.min(cnt * B, 2 * C * cnt);
        } else {
        	cnt = X - cnt;
        	result += Math.min(cnt * A, 2 * C * cnt);
        }
        System.out.println(result);
	}

}
