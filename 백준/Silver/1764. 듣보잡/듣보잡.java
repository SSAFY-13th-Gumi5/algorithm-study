import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static String[] noListen;
    static Set<String> noView;
    static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        noListen = new String[N];
        noView = new HashSet<>();
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            noListen[i] = bf.readLine();
        }

        for (int i = 0; i < M; i++) {
            noView.add(bf.readLine());
        }

        for (int i = 0; i < N; i++) {
            if (noView.contains(noListen[i])) {
                result.add(noListen[i]);
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");
        for (String d : result) {
            sb.append(d).append("\n");
        }

        System.out.println(sb.toString());
    }
}