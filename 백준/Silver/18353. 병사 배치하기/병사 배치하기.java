import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        int [] lis = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = 1;
        }
        for(int i = 0; i < N; i++) {
            for(int j =0; j< i; j ++){
                if(arr[i] < arr[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int result = -1;
        for(int i = 0; i < N; i++) {
            result = Math.max(result, lis[i]);
        }
        System.out.println(N-result);

    }

}