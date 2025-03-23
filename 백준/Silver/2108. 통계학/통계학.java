import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println(Math.round((double) sum / N));

        Arrays.sort(arr);
        System.out.println(arr[N / 2]);


        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(frequencyMap.entrySet());
        freqList.sort((entry1, entry2) -> {
            if (entry2.getValue() == entry1.getValue()) {
                return entry1.getKey() - entry2.getKey(); // 빈도수가 같으면 숫자 작은 순으로
            }
            return entry2.getValue() - entry1.getValue(); // 빈도수가 높은 순으로
        });

        int maxFreq = freqList.get(0).getValue();
        List<Integer> modeCandidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqList) {
            if (entry.getValue() == maxFreq) {
                modeCandidates.add(entry.getKey());
            } else {
                break;
            }
        }

        if (modeCandidates.size() > 1) {
            System.out.println(modeCandidates.get(1));
        } else {
            System.out.println(modeCandidates.get(0));
        }

        System.out.println(max - min);
    }
}