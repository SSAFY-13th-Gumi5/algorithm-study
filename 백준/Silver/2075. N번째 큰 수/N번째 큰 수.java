import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static PriorityQueue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(bf.readLine());
        queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j=0;j<N;j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=1;i<N;i++) {
            queue.poll();
        }

        System.out.println(queue.poll());

    }
}