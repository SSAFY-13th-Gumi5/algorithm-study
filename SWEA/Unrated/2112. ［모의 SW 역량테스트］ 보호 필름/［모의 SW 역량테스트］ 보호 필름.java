import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */

class Solution {
    static int answer = 4;
    static int T, D, W, K;
    static int[][] map = new int[13][20];

    public static boolean checkMap() {
        for (int j = 0; j < W; j++) {
            /*
            cnt = 1
        for r in range(1, D):
            if A[r][c] == A[r-1][c]:
                cnt += 1
            else:
                cnt = 1
            if cnt >= K:        # 동일 특성이 K개 이상이면 break하고 다음 열 검사
                break
        if cnt < K:             # 해당 열에서 동일 특성이 K 미만이면 불합격
            return False
             */

            int cnt = 1;
            for (int i = 1; i < D; i++) {
                if (map[i][j] == map[i - 1][j]) cnt++;
                else cnt = 1;
                if (cnt >= K) break;
            }
            if (cnt < K) return false;
        }
        return true;
    }

    public static void dfs(int a, int b, int[][] map, int n) {
        //checkmap이 true 이면 answer = 갱신
        if (checkMap()) {
            answer = Math.min(answer, a + b);
            return;
        }
        for (int i = n; i < D; i++) {
            int[] map_line = new int[W];
            for (int j = 0; j < W; j++) {  //원래 배열 잠시 복사
                map_line[j] = map[i][j];
            }
            //한줄 A로

            for (int j = 0; j < W; j++) {
                map[i][j] = 0;
            }
            dfs(a + 1, b, map, i + 1);

            //한줄 B로

            for (int j = 0; j < W; j++) {
                map[i][j] = 1;
            }
            dfs(a, b + 1, map, i + 1);


            for (int j = 0; j < W; j++) {  //원래 배열로 되돌리기
                map[i][j] = map_line[j];
            }
        }


    }

    public static void main(String[] args) throws Exception {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 10;

            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0, map, 0);


            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();


    }
}