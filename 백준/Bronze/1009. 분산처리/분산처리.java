import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		int[][] pattern = { { 10, 10, 10, 10 }, { 1, 1, 1, 1 }, { 2, 4, 8, 6 }, { 3, 9, 7, 1 }, { 4, 6, 4, 6 },
				{ 5, 5, 5, 5 }, { 6, 6, 6, 6 }, { 7, 9, 3, 1 }, { 8, 4, 2, 6 }, { 9, 1, 9, 1 } };

		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sc.nextLine();

			int i = a % 10;
			int j = (b - 1) % 4;

			System.out.println(pattern[i][j]);
		}
	}
}