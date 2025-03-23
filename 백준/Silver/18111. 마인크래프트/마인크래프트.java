import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int minH = 256, maxH = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, land[i][j]);
                maxH = Math.max(maxH, land[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        for (int h = minH; h <= maxH; h++) {
            int remove = 0, add = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - h;

                    if (diff > 0) {
                        remove += diff;
                    } else {   
                        add -= diff;
                    }
                }
            }

            if (remove + B >= add) {
                int time = remove * 2 + add;
                if (time < minTime) {
                    minTime = time;
                    bestHeight = h;
                } else if (time == minTime) {
                    bestHeight = Math.max(bestHeight, h);
                }
            }
        }

        System.out.println(minTime + " " + bestHeight);
    }
}