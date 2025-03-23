import java.io.*;
import java.util.*;

public class Main {
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] prevMax = new int[3];
        int[] prevMin = new int[3];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            prevMax[i] = prevMin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] now = new int[3];  // 현재 줄 값
            int[] maxDp = new int[3]; // 현재 줄에서의 최대값
            int[] minDp = new int[3]; // 현재 줄에서의 최소값

            for (int j = 0; j < 3; j++) {
                now[j] = Integer.parseInt(st.nextToken());
            }

            // 최대값 계산
            maxDp[0] = now[0] + Math.max(prevMax[0], prevMax[1]);
            maxDp[1] = now[1] + Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
            maxDp[2] = now[2] + Math.max(prevMax[1], prevMax[2]);

            // 최소값 계산
            minDp[0] = now[0] + Math.min(prevMin[0], prevMin[1]);
            minDp[1] = now[1] + Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);
            minDp[2] = now[2] + Math.min(prevMin[1], prevMin[2]);

            prevMax = maxDp;
            prevMin = minDp;
        }

        int maxResult = Math.max(Math.max(prevMax[0], prevMax[1]), prevMax[2]);
        int minResult = Math.min(Math.min(prevMin[0], prevMin[1]), prevMin[2]);

        System.out.println(maxResult + " " + minResult);
    }
}
