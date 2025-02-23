import java.io.*;
import java.util.*;

class Main {
    static HashMap<Long, Integer> dp;

    static void search(long current, long end, int count){
        if(current > end){
            return;
        }

        // 이미 저장된 값이 현재보다 작거나 같으면 더 이상 탐색할 필요 없음
        if(dp.containsKey(current) && dp.get(current) <= count) {
            return;
        }

        // 현재 횟수 저장
        dp.put(current, count);

        // 두 가지 연산에 대해 재귀적으로 탐색
        search(current * 2, end, count + 1);
        search(current * 10 + 1, end, count + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        search(start, end, 1);

        if(dp.containsKey(end))
            bw.write(dp.get(end) + "\n");
        else
            bw.write("-1\n");

        bw.flush();
        bw.close();
        br.close();
    }
}