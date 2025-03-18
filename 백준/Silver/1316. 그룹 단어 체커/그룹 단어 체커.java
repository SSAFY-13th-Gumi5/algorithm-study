import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static boolean[] alpha;
    static boolean checked;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        result = 0;
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            alpha = new boolean[26];
            checked = true;
            char[] str = s.toCharArray();
            for (int j = 1; j < str.length; j++) {
                if (str[j - 1] != str[j]) {
                    if (alpha[(str[j] - 'a')]) {
                        checked = false;
                        break;
                    } else {
                        alpha[(str[j - 1] - 'a')] = true;
                    }
                } else {
                    continue;
                }
            }
            if (checked) {
                result++;
            }
        }
        System.out.println(result);
    }
}