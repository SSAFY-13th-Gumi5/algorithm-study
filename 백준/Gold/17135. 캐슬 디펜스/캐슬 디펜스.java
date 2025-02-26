import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Enemy {
    int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Archer {
    int x, y;

    public Archer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M, D;
    static int[][] map;
    static int result = 0;
    static ArrayList<Enemy> enemies;
    static ArrayList<Archer> archers;

    private static int getDistance(Enemy enemy, Archer archer) {
        return Math.abs(archer.x - enemy.x) + Math.abs(archer.y - enemy.y);
    }

    private static int game() {
        ArrayList<Enemy> copy = new ArrayList<>();
        for (Enemy e : enemies) {
            copy.add(new Enemy(e.x, e.y));
        }

        int totalKills = 0;

        while (!copy.isEmpty()) {
            HashSet<Integer> toRemove = new HashSet<>();

            for (Archer archer : archers) {
                Enemy target = null;
                int minDist = D + 1;

                for (Enemy enemy : copy) {
                    int dist = getDistance(enemy, archer);

                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && enemy.y < target.y)) {
                            minDist = dist;
                            target = enemy;
                        }
                    }
                }

      
                if (target != null) {
                    toRemove.add(copy.indexOf(target));
                }
            }

            ArrayList<Enemy> newEnemies = new ArrayList<>();
            for (int i = 0; i < copy.size(); i++) {
                if (toRemove.contains(i)) {
                    totalKills++;
                } else if (copy.get(i).x < N - 1) {
                    newEnemies.add(new Enemy(copy.get(i).x + 1, copy.get(i).y));
                }
            }
            copy = newEnemies;
        }

        return totalKills;
    }

    private static void comb(int cnt, int index) {
        if (cnt == 3) {
            int kills = game();
            result = Math.max(result, kills);
            return;
        }

        for (int i = index; i < M; i++) {
            archers.add(new Archer(N, i));
            comb(cnt + 1, i + 1);
            archers.remove(archers.size() - 1);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        enemies = new ArrayList<>();
        archers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    enemies.add(new Enemy(i, j));
                }
            }
        }

        comb(0, 0);
        System.out.println(result);
    }
}
