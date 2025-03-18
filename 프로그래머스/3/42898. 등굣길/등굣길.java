class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        
        // 웅덩이 값을 dp 배열에 초기화해준다.
        for(int[] p : puddles) {
            dp[p[1] - 1][p[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int k =0; k < m; k++) {
                if (i == 0 && k == 0) { // 0,0 일때는 넘어감
                    continue;
                }
                if (dp[i][k] == -1) {
                    dp[i][k] = 0;
                }
                else {
                    if (i > 0) {
                        dp[i][k] += dp[i - 1][k] % 1000000007;
                    } 
                    if (k > 0) {
                        dp[i][k] += dp[i][k - 1] % 1000000007;
                    }
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int k =0; k < m; k++) {
        //         System.out.print(dp[i][k] + " ");
        //     }
        //     System.out.println();
        // }
        
        answer = dp[n -1][m - 1] % 1000000007;
        return answer;
    }
}