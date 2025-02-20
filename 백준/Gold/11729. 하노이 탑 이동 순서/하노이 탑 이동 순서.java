import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, via, to);

        sb.append(from).append(" ").append(to).append("\n");

        hanoi(n - 1, via, to, from);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println((1 << N) - 1);
        hanoi(N, 1, 3, 2);
        System.out.print(sb);
    }
}
