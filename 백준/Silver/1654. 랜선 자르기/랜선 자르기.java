import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int k;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        k = Integer.parseInt(st.nextToken());  // 이미 가지고 있는 랜선 개수
        n = Integer.parseInt(st.nextToken());  // 필요한 랜선 개수

        arr = new int[k];

        long low = 1;
        long high = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        // 초기 설정을 통해 이분 탐색 범위 지정
        if (f(high) >= n) {
            System.out.println(high);
            return;
        }

        // 이분 탐색
        while (low < high - 1) {
            long mid = (low + high) / 2;
            if (f(mid) >= n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }

    // 특정 랜선 길이로 만들 수 있는 랜선 개수 계산
    static int f(long h) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i] / h;
        }
        return sum;
    }
}