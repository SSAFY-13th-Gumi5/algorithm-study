import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, delete, root;
    static List<Integer>[] tree;
    static int cnt;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        parent = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            parent[i] = p;
            if (p == -1) {
                root = i;
            } else {
                tree[p].add(i);
            }
        }

        delete = Integer.parseInt(bf.readLine());

        if (delete == root) {
            System.out.println(0);
            return;
        }

        int parOfDelete = parent[delete];
        tree[parOfDelete].remove(Integer.valueOf(delete));

        dfs(root);
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        if (tree[node].isEmpty()) {
            cnt++;
            return;
        }

        for (int i : tree[node]) {
            dfs(i);
        }
    }
}