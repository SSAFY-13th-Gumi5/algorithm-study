import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class BC {
	int x, y, c, p; // X, Y, 충전범위, 처리량

	public BC(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}

	public boolean isReachable(int x, int y) {
		int distance = Math.abs(this.x - x) + Math.abs(this.y - y);
		return distance <= this.c;
	}

}

public class Solution {
	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		final int[] dx = { 0, 0, 1, 0, -1 };
		final int[] dy = { 0, -1, 0, 1, 0 };
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int M, A; // 총 이동 시간, BC의 개수
			ArrayList<BC> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			int[] arrA = new int[M];
			int[] arrB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x, y, c, p;
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());

				list.add(new BC(x, y, c, p));
			}
			Collections.sort(list, new Comparator<BC>() {
				@Override
				public int compare(BC o1, BC o2) {
					// TODO Auto-generated method stub
					return o2.p - o1.p;
				}
			});

			int totalCharge = 0;
			int aX = 1; // A의 현재 X 위치
			int aY = 1; // A의 현재 Y 위치
			int bX = 10; // B의 현재 X 위치
			int bY = 10; // B의 현재 Y 위치

			for (int time = 0; time <= M; time++) {

				// A와 B가 각각 충전할 수 있는 배터리 목록을 확인
				ArrayList<BC> reachableA = new ArrayList<>();
				ArrayList<BC> reachableB = new ArrayList<>();

				for (BC bc : list) {
					if (bc.isReachable(aX, aY)) {
						reachableA.add(bc);
					}
					if (bc.isReachable(bX, bY)) {
						reachableB.add(bc);
					}
				}

				// A와 B가 충전할 수 있는 최대 처리량을 선택
				if (reachableA.size() > 0 && reachableB.size() > 0) {
					BC bestA = reachableA.get(0);
					BC secondA = reachableA.size() > 1 ? reachableA.get(1) : new BC(-1, -1, -1, Integer.MIN_VALUE);
					BC bestB = reachableB.get(0);
					BC secondB = reachableB.size() > 1 ? reachableB.get(1) : new BC(-1, -1, -1, Integer.MIN_VALUE);

					// A와 B가 동일한 배터리 충전기를 선택할 경우
					if (bestA == bestB) {
						totalCharge += Math.max(bestA.p, Math.max(bestA.p + secondA.p, bestB.p + secondB.p));

					} else {
						totalCharge += bestA.p + bestB.p;
					}
				} else if (reachableA.size() > 0) {
					totalCharge += reachableA.get(0).p;
				} else if (reachableB.size() > 0) {
					totalCharge += reachableB.get(0).p;
				}
				if (time == M)
					break;
				aX += dx[arrA[time]];
				aY += dy[arrA[time]];
				bX += dx[arrB[time]];
				bY += dy[arrB[time]];

			}
			bw.write("#" + test_case + " " + totalCharge + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}
}