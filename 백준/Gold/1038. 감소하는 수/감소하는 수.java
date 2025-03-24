import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    static int N;
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();

        if (N >= 0 && N < 10) {
            System.out.println(N);
        } else if (N >= 1023) {
            System.out.println(-1);
        } else {
            list.add(0L);
            for (int i = 1; i < 10; i++) {
                decreaseNumber(i, i);
            }

            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    private static void decreaseNumber(long num, int last) {
        list.add(num);
        for (int i = 0; i < last; i++) {
            decreaseNumber(num * 10 + i, i);
        }
    }
}