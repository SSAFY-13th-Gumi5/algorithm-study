import java.io.*;
import java.util.*;

public class Main {

    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int low = 1;
        int high = arr[N-1];

        while (low <= high) {
            int mid = (low + high)/2;
            int cnt =0;
            for(int i =0; i <N; i ++){
                cnt += arr[i]/mid;
            }
            if(cnt < M){
                high = mid-1;
            }
            else{
                total = mid;
                low = mid+1;
            }
        }

        System.out.println(total);
    }


}