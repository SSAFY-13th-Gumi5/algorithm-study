import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		int answer = 1;
		int[] digit = new int[] { 0, 10, 90, 810, 7290 };
		int[] chr = new int[] { 0, 26, 650, 16250, 406250 };
		for (int i = 0; i < s.length();) {
			int len = getCount(s, i);
			switch (s.charAt(i)) {
			case 'd':
				answer *= digit[len];
				break;
			case 'c':
				answer *= chr[len];
			}
			i += len;
		}
		System.out.println(answer);

	}

	private static int getCount(String s, int n) {
		for (int i = n + 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(n))
				return i - n;
		}
		return s.length() - n;
	}

}
