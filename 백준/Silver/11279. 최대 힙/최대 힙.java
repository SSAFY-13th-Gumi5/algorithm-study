import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    static PriorityQueue<Integer> pQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(bf.readLine());
            if (a == 0) {
                if (pQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pQueue.poll()).append("\n");
                }
            } else {
                pQueue.offer(a);
            }
        }
        System.out.println(sb.toString());
    }
}