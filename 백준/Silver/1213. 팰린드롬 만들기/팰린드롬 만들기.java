import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static String str;
  static char[] c;
  static char[] result;
  static int[] alpha = new int[26];
  static boolean isPal = true;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    str = bf.readLine();
    c = str.toCharArray();
    result = new char[c.length];
    for (int i = 0; i < alpha.length; i++) {
      alpha[i] = 0;
    }

    Arrays.sort(c);

    for (int i = 0; i < c.length; i++) {
      alpha[c[i] - 'A']++;
    }

    isPalindrome(alpha);
    for (char a : result) {
      System.out.print(a);
    }
  }

  private static void isPalindrome(int[] alpha) {
    if (c.length % 2 == 0) {
      for (int i = 0; i < alpha.length; i++) {
        if (alpha[i] % 2 != 0) {
          isPal = false;
        }
      }
    } else if (c.length % 2 != 0) {
      int count = 0;
      for (int i = 0; i < alpha.length; i++) {
        if (alpha[i] % 2 != 0) {
          count++;
        }
      }
      if (count != 1)
        isPal = false;
    }

    if (!isPal) {
      System.out.print("I'm Sorry Hansoo");
      System.exit(0); // 프로그램 종료
    } else if (isPal) {
      makePalindrome(c, result);
    }
  }

  private static void makePalindrome(char[] c, char[] result) {
    if (c.length % 2 == 0) {
      int count = 0;
      for (int i = 0; i < c.length; i += 2) {
        result[count] = c[i];
        result[result.length - count - 1] = c[i + 1];
        count++;
      }
    } else {
      int count = 0;
      for (int i = 0; i < c.length; i += 2) {
        if (!(i == c.length - 1)) {
          if (c[i] != c[i + 1]) {
            result[result.length / 2] = c[i];
            i--;
          } else {
            result[count] = c[i];
            result[result.length - count - 1] = c[i + 1];
            count++;
          }
        } else {
          result[result.length / 2] = c[i];
        }
      }
    }
  }
}
