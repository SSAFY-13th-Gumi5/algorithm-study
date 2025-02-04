import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {


    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A, B, C, X, Y, result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        while (X > 0 || Y > 0) {
            if (X > 0 && Y > 0) {
                if (A + B > 2 * C) {
                    result += 2 * C;
                    X--;
                    Y--;
                } else {
                    result += A + B;
                    X--;
                    Y--;
                }
                continue;
            }

            if (X > 0) {
                if (A > 2 * C) {
                    result += 2 * C;
                    X--;
                    Y--;
                } else {
                    result += A;
                    X--;
                }
            }

            if (Y > 0) {
                if (B > 2 * C) {
                    result += 2 * C;
                    X--;
                    Y--;
                } else {
                    result += B;
                    Y--;
                }
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}