import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long A, B;
    A = sc.nextLong();
    B = sc.nextLong();

    if (B < 4) {
      System.out.println(0);
      sc.close();
      return;
    }


    int max_idx = (int) Math.sqrt(B) + 1;
    boolean[] eratos = new boolean[max_idx];
    for (int i = 2; i < max_idx; i++) eratos[i] = true;

    for (int i = 2; i < (long) Math.sqrt(max_idx) + 1; i++) {
      if (eratos[i] == false) continue;

      int j = 2;
      while (i*j < max_idx) {
        eratos[i*j] = false;
        j++;
      }
    }

    long answer = 0;
    for (int i = 2; i < max_idx; i++) {
      if (eratos[i] == false) continue;

      long val = (long) i * i;
      while (val <= B) {
        if (val >= A) {
          answer++;
        }
        if (val > Long.MAX_VALUE / i) break; // 오버플로우 방지
        val *= i;
      }
    }

    System.out.println(answer);

    sc.close();
  }
}