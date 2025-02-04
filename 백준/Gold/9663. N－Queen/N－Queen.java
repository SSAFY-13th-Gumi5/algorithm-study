import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N, ans = 0;
    static int[] v1, v2, v3;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        v1 = new int[N];
        v2 = new int[2 * N - 1];
        v3 = new int[2 * N - 1];
        
        dfs(0);
        
        System.out.println(ans);
    }
    
    public static void dfs(int i) {
        if (i == N) {
            ans++;
            return;
        }
        for (int k = 0; k < N; k++) {
            if (v1[k] == 0 && v2[i - k + N - 1] == 0 && v3[i + k] == 0) {
                v1[k] = v2[i - k + N - 1] = v3[i + k] = 1;
                dfs(i + 1);
                v1[k] = v2[i - k + N - 1] = v3[i + k] = 0;
            }
        }
    }

}
