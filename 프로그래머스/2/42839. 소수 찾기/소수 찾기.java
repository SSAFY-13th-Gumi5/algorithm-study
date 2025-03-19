import java.util.*;

// 입력 받은 문자열을 문자 하나씩 쪼갠다음
// 문자들로 조합할 수 있는 모든 수를 set에 넣는다. -> 부분 집합
// set에 넣은 수를 하나씩 꺼내며 소수인지 판별한다. -> 에르테네스의 체?를 사용

class Solution {
    static int answer = 0;
    static boolean[] visit;
    static boolean[] isPrimeArr = new boolean[10000000];
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {

        char[] nums = numbers.toCharArray();
        setPrime(isPrimeArr, 9999999);
        visit = new boolean[numbers.length()];
        dfs(0, new int[numbers.length()], numbers);
        for (int n : set) {
            if (searchPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int n, int[] arr, String numbers) {
        StringBuilder sb = new StringBuilder();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[n] = numbers.charAt(i) - '0';
                dfs(n + 1, arr, numbers);
                visit[i] = false;
            }
        }
    }
    
    public static boolean searchPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void setPrime(boolean[] isPrime, int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    isPrime[k] = false;
                }
            }
        }
    }
    
}