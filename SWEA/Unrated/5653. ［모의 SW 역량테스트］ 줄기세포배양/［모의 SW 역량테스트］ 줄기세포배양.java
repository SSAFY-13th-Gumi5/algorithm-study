import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Cell {
    int x, y, k, sec, life;

    public Cell(int x, int y, int k, int life,  int sec) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.life = life;

        //현재 생명 주기: 0보다 크면 비활성 상태, 음수면 활성상태, 0이면 첫 활성상태, -k보다 작으면 죽은 상태
        this.sec = sec;
    }

    @Override
    public String toString() {
        return
                "[" + (y - 500) +
                        "][" + (x-500) +
                        "] , k=" + k +
                        ", life=" + life +
                        ", sec=" + sec +
                        "\n";
    }
}

class Solution {
    static final int MAX = 500;

    public static void main(String args[]) throws Exception {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int T, N, M, K;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[][] visited = new boolean[1000][1000];
            PriorityQueue<Cell> q = new PriorityQueue<>((o1, o2) -> {
                if (o1.sec == o2.sec) {
                    if(o1.life == o2.life){
                        return o2.k - o1.k;
                    }
                    return o1.life - o2.life;
                }
                return o1.sec - o2.sec;
            });
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = MAX; i < N + MAX; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = MAX; j < M + MAX; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    if (k > 0) {
                        q.add(new Cell(j, i, k, k,0));
                        visited[i][j] = true;
                    }

                }
            }

            while (!q.isEmpty()) {
                if (q.peek().sec ==  K) break;
                Cell cur = q.poll();
                if (cur.life == 0) {
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if (!visited[ny][nx]) {
                            visited[ny][nx] = true;
                            q.add(new Cell(nx, ny, cur.k, cur.k, cur.sec + 1));
                        }
                    }
                }

                if(-cur.k  < cur.life - 1)  //죽은 세포는 추가 하지말것
                    q.add(new Cell(cur.x, cur.y, cur.k, cur.life-1, cur.sec + 1));
            }

            bw.write( "#"+test_case+" " + q.size());
//            bw.write(Arrays.toString(q.toArray()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();


    }
}