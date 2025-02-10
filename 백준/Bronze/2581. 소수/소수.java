import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean isPrime [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n ; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int min = 0;
        int sum = 0;
        boolean flag = false;

        for (int i = m; i <= n; i++) {
            if (isPrime[i] && !flag) {
                min = i;
                flag = true;
            }
            if (isPrime[i]) {
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}