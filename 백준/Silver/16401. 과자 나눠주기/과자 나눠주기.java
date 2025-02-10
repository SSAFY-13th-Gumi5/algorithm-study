import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snack = new int[N];

        String t = bf.readLine();
        StringTokenizer st2 = new StringTokenizer(t);
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(snack);
        int left = 1;
        int right = snack[N - 1];
        int mid = (left + right) / 2;
        int count = 0;
        int result = 0;

        while (left <= right) {
            count = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                count += snack[i] / mid;
            }

            if (count >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}