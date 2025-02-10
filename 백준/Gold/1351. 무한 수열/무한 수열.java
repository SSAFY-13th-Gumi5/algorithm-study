import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    static long N, P, Q;
    static Map<Long, Long> A = new HashMap<>();

    public static Long dfs(long n) {
        if (n == 0) return 1L;
        if (A.containsKey(n)) return A.get(n);
        long result = dfs(n / P) + dfs(n / Q);
        A.put(n, result);
        return result;

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sb;

        sb = new StringTokenizer(br.readLine());

        N = Long.parseLong(sb.nextToken());
        P = Long.parseLong(sb.nextToken());
        Q = Long.parseLong(sb.nextToken());
        long answer = dfs(N);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}




