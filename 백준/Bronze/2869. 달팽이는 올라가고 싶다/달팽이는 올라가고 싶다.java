import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A, B, V, answer;
		A = sc.nextInt();
		B = sc.nextInt();
		V = sc.nextInt();

		V -= B;
		A -= B;
		if (V % A == 0) {
			answer = V / A;
		} else {
			answer = V / A + 1;
		}
		System.out.println(answer);
	}
}


