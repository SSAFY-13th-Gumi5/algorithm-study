import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= N; i ++){
            int a = Integer.parseInt(br.readLine());
            pq.add(a);
            if(a == 0){
                if(!pq.isEmpty()) {
                    sb.append(pq.poll() + "\n");
                }else{
                    sb.append("0"+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}