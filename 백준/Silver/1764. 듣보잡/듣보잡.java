import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        
        Set<String> persons1 = new HashSet<>();
        Set<String> persons2 = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            persons1.add(scanner.nextLine());
        }
        
        for (int i = 0; i < M; i++) {
            persons2.add(scanner.nextLine());
        }
        
        // 교집합 구하기
        persons1.retainAll(persons2);
        
        // 리스트로 변환 후 정렬
        List<String> result = new ArrayList<>(persons1);
        Collections.sort(result);
        
        // 결과 출력
        System.out.println(result.size());
        for (String person : result) {
            System.out.println(person);
        }
    }
}