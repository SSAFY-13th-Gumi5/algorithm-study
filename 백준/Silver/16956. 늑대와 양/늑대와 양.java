import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
		static int r;
		static int c;
		static char[][] arr;
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c];
			
			for (int i = 0; i < r; i++) {
				String str = br.readLine();
				for (int k = 0; k < c; k++) {
					arr[i][k] = str.charAt(k);
				}
			}
			
			for (int i = 0; i < r; i++) {
				for (int k = 0; k < c; k++) {
					if (arr[i][k] == 'S') {
						if (!bfs(i, k)) {
							System.out.println(0);
							return ;
						}
					}
				}
			}
			System.out.println("1\n");
			for (int i =0; i < r; i++) {
				for (int k =0 ; k < c; k++) {
					System.out.print(arr[i][k]);
				}
				System.out.println();
			}
			
		}
		
		public static boolean bfs(int a, int b) {
			int[] dx = {-1, 1, 0 , 0};
			int[] dy = {0, 0, -1, 1};
			
			 for (int i = 0; i < 4; i++) {
		            int nx = b + dx[i];
		            int ny = a + dy[i];

		            if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
		                if (arr[ny][nx] == 'W') {
		                    return false; // 양 바로 옆에 늑대가 있으면 실패
		                }
		                if (arr[ny][nx] == '.') {
		                    arr[ny][nx] = 'D'; // 빈 칸이면 벽 설치
		                }
		            }
		        }
			
			return true;
		}
}
