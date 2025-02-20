import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */


class Gear {
    List<Integer> gears;
    final int TOP = 0;
    final int RIGHT = 2;
    final int LEFT = 6;

    public Gear(int[] arr) {
        gears = new ArrayList<>();
        for (int a : arr) {
            gears.add(a);
        }
    }

    int getLeft() {
        return gears.get(LEFT);
    }

    int getRight() {
        return gears.get(RIGHT);
    }

    int getTop() {
        return gears.get(TOP);
    }

    // 첫 번째 요소를 pop하여 마지막에 추가 (오른쪽 회전)
    void rotate(int dir) {
        if (dir == 1) {
            rotateRight();
        } else {
            rotateLeft();
        }
    }

    // 첫 번째 요소를 pop하여 마지막에 추가 (오른쪽 회전)
    private void rotateLeft() {
        int first = gears.remove(0);
        gears.add(first);
    }


    // 마지막 요소를 pop하여 처음에 추가 (왼쪽 회전)
    private void rotateRight() {
        int last = gears.remove(gears.size() - 1);
        gears.add(0, last);
    }

    @Override
    public String toString() {
        return Arrays.toString(gears.toArray());
    }
}


class Solution {

    static Gear[] gears = new Gear[4];


    public static void rotate(int pos, int dir, boolean[] visited) {
        visited[pos] = true;
        if (pos > 0 && gears[pos].getLeft() != gears[pos - 1].getRight() && !visited[pos - 1])
            rotate(pos - 1, -dir, visited);

        if (pos < 3 && gears[pos].getRight() != gears[pos + 1].getLeft() && !visited[pos + 1])
            rotate(pos + 1, -dir, visited);

        gears[pos].rotate(dir);
//        System.out.println(pos+"번째 톱니바퀴를 "+dir+"회전");

    }

    public static void main(String[] args) throws Exception {

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            int K = Integer.parseInt(br.readLine());
            for (int g = 0; g < 4; g++) {
                int[] input = new int[8];
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 8; i++) {
                    input[i] = Integer.parseInt(st.nextToken());
                }
                gears[g] = new Gear(input);
            }

            for (int k = 0; k < K; k++) {
                int pos, dir;
                boolean[] visited = new boolean[4];
                st = new StringTokenizer(br.readLine());
                pos = Integer.parseInt(st.nextToken()) - 1; //index는 0부터 시작이므로
                dir = Integer.parseInt(st.nextToken());

                rotate(pos, dir, visited);

//                for(int g=0;g<4;g++) {
//                    System.out.println(gears[g]);
//                }
//                System.out.println();
            }

            for (int g = 0; g < 4; g++) {
                answer += gears[g].getTop() * (1 << g);

            }


            bw.write("#" + test_case + " " + answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();


    }
}