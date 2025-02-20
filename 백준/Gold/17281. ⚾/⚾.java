import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] scores;
    static int[] permutation = new int[9];
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation[3] = 0;
        visit[0] = true;

        getPermutation(0);

        System.out.println(result);
    }

    private static void getPermutation(int depth) {
        if (depth == 9) {
            playGame();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            permutation[depth] = i;

            if (depth == 2) {
                getPermutation(depth + 2);
            } else {
                getPermutation(depth + 1);
            }

            visit[i] = false;
        }
    }

    private static void playGame() {
        int gameScore = 0;
        int base1;
        int base2;
        int base3;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            int outCount = 0;
            base1 = base2 = base3 = 0;

            while (outCount != 3) {
              
                int getScore = scores[i][permutation[idx]];


                if (getScore == 0) {
                    outCount++;
                }

                else if (getScore == 1) {
                    gameScore += base3;

                    base3 = base2;
                    base2 = base1;
                    base1 = 1;
                }

                else if (getScore == 2) {
                    gameScore += base3 + base2;
                    base3 = base1;
                    base1 = 0;
                    base2 = 1;
                }

                else if (getScore == 3) {
                    gameScore += base1 + base2 + base3;
                    base1 = base2 = 0;
                    base3 = 1;
                }

                else if (getScore == 4) {
                    gameScore += base1 + base2 + base3 + 1;
                    base1 = base2 = base3 = 0;
                }

                idx = (idx + 1) % 9;
            }
        }

        if (result < gameScore) result = gameScore;
    }
}