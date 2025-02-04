import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L;
		String str;
		L = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();

		long answer = 0;
		long pow = 1;
		int s_prime = 31;
		int l_prime = 1234567891;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			answer = (answer + (c - 'a' + 1) * pow % l_prime) % l_prime;
			pow = (pow * s_prime) % l_prime;
		}
		System.out.println(answer);
	}

}
