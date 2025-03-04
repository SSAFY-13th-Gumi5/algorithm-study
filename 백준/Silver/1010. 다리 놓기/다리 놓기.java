import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
//    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);

//            result=0;
//            comb(0,1);
//            System.out.println(result);

            System.out.println(comb(m,n));
        }
    }

    //start: 다음 선택할 숫자의 시작점
//    public static void comb(int cnt, int start) {
//        if (cnt == n) {
//            result++;
//            return;
//        }
//
//        for (int i = start; i <= m; i++) {
//
//            comb(cnt + 1, i + 1);
//        }
//    }

    public static long comb(int m, int n){
        if(n==0 || m==n){
            return 1;
        }

        long result=1;
        for(int i=0; i<n; i++){
            result=result*(m-i)/(i+1);
        }
        return result;
    }
}