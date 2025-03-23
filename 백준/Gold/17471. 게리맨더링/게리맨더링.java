import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/17471
public class Main {

  private static int N; // 구역의 개수
  private static int[] population; // 각 구역의 인구 수
  private static int[][] adjMatrix; // 인접행렬
  private static int[] parents; // 각 구역이 어느 선거구에 포함되었는지 확인하기 위한 배열
  private static int min; // 두 선거구의 인구 차이의 최솟값

  // 결과를 한 번에 출력하기 위한 StringBuilder
  private static StringBuilder sb = new StringBuilder();

  public static void main(String args[]) throws Exception {

    /**
     * 0. 입력파일 읽어들이기
     */
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 1. 입력 파일 객체화
     */
    N = Integer.parseInt(in.readLine());

    population = new int[N + 1]; // 각 구역의 인구 수 (1번부터 사용)
    String[] split = in.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      population[i] = Integer.parseInt(split[i - 1]);
    }

    adjMatrix = new int[N + 1][N + 1];
    for (int from = 1; from <= N; from++) {
      split = in.readLine().split(" ");

      int cnt = Integer.parseInt(split[0]);
      for (int j = 1; j <= cnt; j++) {
        int to = Integer.parseInt(split[j]);
        // 구역 A가 구역 B와 인접하면 구역 B도 구역 A와 인접하다. 인접한 구역이 없을 수도 있다.
        adjMatrix[from][to] = adjMatrix[to][from] = 1; // 1은 서로 연결되어 있다는 뜻
      }
    }

    /**
     * 2. 알고리즘 풀기
     */

    // 두 선거구의 인구 차이의 최솟값 (두 선거구로 나눌 수 없는 경우는 -1)
    min = Integer.MAX_VALUE;

    // 1. 구역들을 두 선거구로 나눌 수 있는 방법을 구한다. (부분집합)
    subSet();

    /**
     * 3. 정답 출력
     */
    if (min == Integer.MAX_VALUE) {
      sb.append(-1);
    } else {
      sb.append(min);
    }
    System.out.println(sb);
  }

  private static void subSet() {

    // 바이너리 카운팅
    // 공집합과 모든 원소를 포함한 집합을 제외한 모든 부분집합 구하기
    // caseCount가 (2^N / 2)부터 집합 구성이 대칭을 이루기 때문에 반을 나눠줬다.
    for (int flag = 1, caseCount = 1 << N; flag < (caseCount / 2); flag++) {

      // 구역들을 선거구 2개로 나눈다.
      List<Integer> groupA = new ArrayList<>();
      List<Integer> groupB = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        if ((flag & (1 << i)) != 0) {
          groupA.add(i + 1); // 정점 번호는 1번부터 시작
        } else {
          groupB.add(i + 1); // 정점 번호는 1번부터 시작
        }
      }
      /*
       * System.out.println(groupA); System.out.println(groupB); System.out.println("=============="
       * + flag + " / " + caseCount);
       */

      // 2. 서로소 집합을 이용하여 나눈 구역들을 union 한다.
      // parents 배열 초기화
      makeSet();

      // 선거구 A에 포함된 구역들을 union 한다.
      for (int i = 0; i < groupA.size() - 1; i++) {
        for (int j = i + 1; j < groupA.size(); j++) {
          int from = groupA.get(i);
          int to = groupA.get(j);
          if (adjMatrix[from][to] == 1) { // 두 구역이 서로 연결되어 있다면
            union(from, to); // 두 구역을 합치기
          }
        }
      }

      // 선거구 B에 포함된 구역들을 union 한다.
      for (int i = 0; i < groupB.size() - 1; i++) {
        for (int j = i + 1; j < groupB.size(); j++) {
          int from = groupB.get(i);
          int to = groupB.get(j);
          if (adjMatrix[from][to] == 1) { // 두 구역이 서로 연결되어 있다면
            union(from, to); // 두 구역을 합치기
          }
        }
      }

      // 모든 구역에 대해 find 수행하여 path compression 한다. (최상단 부모 확인을 위해)
      for (int i = 0; i <= N; i++) {
        findSet(i);
      }

      // 3. 모든 구역에 대해 대표자가 총 2개 존재한다면 두 선거구로 나눌 수 있는 경우이다.
      Arrays.sort(parents); // 대표자의 개수 파악을 쉽게 하기 위해 정렬
      // System.out.println(Arrays.toString(parents));

      int cntOfParents = 0;
      for (int i = 0; i < parents.length - 1; i++) {
        if (parents[i] != parents[i + 1]) {
          cntOfParents++;
        }
      }

      // 두 선거구로 나눌 수 있는 경우에는 두 선거구의 인구의 차이를 구한다.
      if (cntOfParents == 2) {
        int cntA = 0;
        int cntB = 0;

        for (int i = 0; i < groupA.size(); i++) {
          int zone = groupA.get(i);
          cntA += population[zone];
        }

        for (int i = 0; i < groupB.size(); i++) {
          int zone = groupB.get(i);
          cntB += population[zone];
        }

        min = Math.min(min, Math.abs(cntA - cntB));
      }
    }
  }

  private static void makeSet() {
    parents = new int[N + 1]; // 선거구 (1번부터 사용)
    for (int i = 0; i <= N; i++) {
      parents[i] = i;
    }
  }

  private static int findSet(int a) { // a의 대표자 찾기

    if (parents[a] == a) {
      return a;
    }

    return parents[a] = findSet(parents[a]); // 우리의 대표자를 나의 부모로 .. : path compression
  }

  private static boolean union(int a, int b) { // 리턴 값 : true ==> union 성공
    int aRoot = findSet(a);
    int bRoot = findSet(b);

    if (aRoot == bRoot) {
      return false;
    }

    parents[bRoot] = aRoot;
    return true;
  }
}
