import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long [] result = new long[N+1];
        if(N ==1){
            System.out.println(1);
            return;
        }
        if(N >=2 ) {
            result[1] = 1;
        }
        for (int i = 2; i <=N; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        System.out.println(result[N]);
    }

}