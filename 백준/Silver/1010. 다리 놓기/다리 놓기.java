import java.io.*;
import java.util.*;

public class Main {
    static int Test_Case;
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Test_Case = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < Test_Case; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[M + 1][N + 1]; // 조합 결과 저장

            if (M / 2 < N) {
                N = M - N;
            }

            // int → String 변환 후 BufferedWriter 사용
            bw.write(String.valueOf(comb(M, N)));
            bw.newLine(); // 개행 추가
        }

        bw.flush(); // 최종적으로 한 번만 flush()
        bw.close(); // BufferedWriter 닫기
        br.close(); // BufferedReader 닫기
    }

    private static int comb(int a, int b) {
        if (arr[a][b] != 0) return arr[a][b];
        if (a == b || b == 0) return arr[a][b] = 1;
        return arr[a][b] = comb(a - 1, b) + comb(a - 1, b - 1);
    }
}