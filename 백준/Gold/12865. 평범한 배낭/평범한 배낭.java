import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // 아이템 개수
		int W = sc.nextInt();  // 가방에 담을 수 있는 무게
		
		int[] weights = new int[N + 1];  // 무게 배열
		int[] profits = new int[N + 1];  // 가치 배열
		
		// 물건번호는 1부터 출발
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		// 1. 동적 테이블 작성
		int[][] D = new int[N + 1][W + 1];
		
		// 2. 베이스값 채우기
		// 첫 번째 행과, 첫 번째 열에 이미 0이 들어가 있으므로 이미 처리됨
		
		// 3. 점화식 이용
		for (int item = 1; item <= N; item++) {
			
			int itemWeight = weights[item];  // 현재 아이템 무게
			int itemProfit = profits[item];  // 현재 아이템 가치
			
			// 임시 배낭의 무게를 1씩 증가 시켜나가기
			for (int weight = 1; weight <= W; weight++) {
				
				// 아이템을 임시 배낭에 담을 수 있는 경우
				if (itemWeight <= weight) {
					D[item][weight] = Math.max(D[item - 1][weight], D[item - 1][weight - itemWeight] + itemProfit);
				}
				// 아이템을 임시 배낭에 담을 수 없는 경우
				else {
					D[item][weight] = D[item - 1][weight];
				}
			}
		}
		
		System.out.println(D[N][W]);
	}
}

