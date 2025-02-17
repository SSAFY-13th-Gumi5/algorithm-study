import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(bf.readLine());
    String s = st.nextToken();

    int[] alphabet = new int[26];

    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'A']++;
    }
    int odd_cnt = 0;
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] % 2 == 1)
        odd_cnt++;
    }
    if (s.length() % 2 == 0 && odd_cnt != 0) {
      System.out.println("I'm Sorry Hansoo");
      return;
    }
    if (s.length() % 2 == 1 && odd_cnt >= 2) {
      System.out.println("I'm Sorry Hansoo");
      return;
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    StringBuilder sb_for_odd = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] % 2 == 0 && alphabet[i] > 0) {
        for (int j = 0; j < alphabet[i] / 2; j++) {
          sb1.append((char) (i + 'A'));
          sb2.insert(0, (char) (i + 'A'));
        }
      }
      if (alphabet[i] % 2 == 1) {
        sb_for_odd.append((char) (i + 'A'));
        for (int j = 0; j < alphabet[i] / 2; j++) {
          sb1.append((char) (i + 'A'));
          sb2.insert(0, (char) (i + 'A'));
        }
      }
    }
    System.out.println(sb1.append(sb_for_odd).append(sb2));
  }
}