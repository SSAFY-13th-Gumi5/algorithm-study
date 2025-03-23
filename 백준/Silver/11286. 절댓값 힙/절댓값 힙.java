import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        int num1 = Math.abs(o1);
        int num2 = Math.abs(o2);

        if (num1 == num2) {
          return o1 - o2;
        }
        // TODO Auto-generated method stub
        return Math.abs(o1) - Math.abs(o2);
      }

    });

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) {
        if (priorityQueue.isEmpty()) {
          sb.append(0 + "\n");
        } else
          sb.append(priorityQueue.poll() + "\n");
      } else {
        priorityQueue.offer(num);
      }

    }
    System.out.println(sb);
  }


}