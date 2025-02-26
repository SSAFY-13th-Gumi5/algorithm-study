import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int C = Integer.parseInt(br.readLine());
        DecimalFormat df = new DecimalFormat("0.000");

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double sum = 0;
            
            for (int i =0; i < n; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            	sum += arr[i];
            }
            
            double mean = (sum / n);
            double cnt = 0;
            
            for (int i = 0; i < n; i++) {
            	if (arr[i] > mean) {
            		cnt++;
            	}
            }
            sb.append(String.format("%.3f", (cnt / n) * 100) + "%" + "\n");
        }

        System.out.println(sb);
    }
}
