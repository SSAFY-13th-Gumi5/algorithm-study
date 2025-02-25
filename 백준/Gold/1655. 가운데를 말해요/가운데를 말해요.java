import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.print.attribute.standard.PrintQuality;

class Main {
    private static PriorityQueue<Integer> lowQ;
    private static PriorityQueue<Integer> highQ;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        lowQ = new PriorityQueue<>(Collections.reverseOrder());
        highQ = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(bf.readLine());

            if (lowQ.isEmpty() || a <= lowQ.peek()) {
                lowQ.offer(a);
            } else {
                highQ.offer(a);
            }

            if (lowQ.size() > highQ.size() + 1) {
                highQ.offer(lowQ.poll());
            } else if (highQ.size() > lowQ.size() + 1) {
                lowQ.offer(highQ.poll());
            }

            if (i % 2 == 1) {
                if (lowQ.size() > highQ.size()) {
                    sb.append(lowQ.peek()).append("\n");
                } else if (highQ.size() > lowQ.size()) {
                    sb.append(highQ.peek()).append("\n");
                }
            } else {
                if (lowQ.peek() > highQ.peek()) {
                    sb.append(highQ.peek()).append("\n");
                } else {
                    sb.append(lowQ.peek()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}