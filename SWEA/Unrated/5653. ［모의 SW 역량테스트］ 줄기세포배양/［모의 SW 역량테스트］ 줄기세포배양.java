import java.io.*;
import java.util.*;

public class Solution {
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class Cell {
        int x, y;
        int life;      // 생명력
        int createTime; // 생성 시간
        int state;     // 0: 비활성, 1: 활성, 2: 죽음

        public Cell(int x, int y, int life, int createTime, int state) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.createTime = createTime;
            this.state = state;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Map<Point, Cell> cells_lived = new HashMap<>();
            Set<Point> cells_dead = new HashSet<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int life = Integer.parseInt(st.nextToken());
                    if (life == 0) continue;
                    cells_lived.put(new Point(i, j), new Cell(i, j, life, 0, 0));
                }
            }

            int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

            for (int time = 1; time <= k; time++) {
                Map<Point, Cell> newCells = new HashMap<>(); // 새로 번식하는 세포들
                List<Point> dead = new ArrayList<>(); // 새로 죽는 세포들

                for (Map.Entry<Point, Cell> entry : cells_lived.entrySet()) {
                    Point pos = entry.getKey();
                    Cell cell = entry.getValue();

                    if (cell.state == 2) continue; // 이미 죽은 세포는 건너뜀

                    // 비활성 상태에서 활성 상태로 전환
                    if (cell.state == 0 && (cell.createTime + cell.life) == time) {
                        cell.state = 1;
                    }
                    // 활성 상태일 때
                    else if (cell.state == 1) {
                        // 번식 진행
                        if (cell.createTime + cell.life + 1 == time) {
                            for (int i = 0; i < 4; i++) {
                                int nx = cell.x + dx[i];
                                int ny = cell.y + dy[i];
                                Point next = new Point(nx, ny);

                                // 이미 세포가 존재하는 경우
                                if (cells_lived.containsKey(next) || cells_dead.contains(next)) continue;

                                // 동일 위치에 두 개 이상이 번식하려 할 경우, 생명력 높은 세포 선택
                                if (!newCells.containsKey(next) || newCells.get(next).life < cell.life) {
                                    newCells.put(next, new Cell(nx, ny, cell.life, time, 0));
                                }
                            }
                        }

                        // 세포 사망
                        if (cell.createTime + cell.life * 2 == time) {
                            cell.state = 2;
                            dead.add(pos);
                        }
                    }
                }

                // 새로운 세포 추가
                cells_lived.putAll(newCells);
                // 죽은 세포 제거
                for (Point point : dead) {
                    cells_lived.remove(point);
                }
                cells_dead.addAll(dead);
            }

            sb.append('#').append(tc).append(' ').append(cells_lived.size()).append('\n');
        }

        br.close();
        System.out.print(sb);
    }
}
