import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] sizes) {
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                sort(sizes, i);
            }
        }
        
        Arrays.sort(sizes, (a, b) -> Integer.compare(b[0], a[0]));
        
        int maxW = sizes[0][0];
        
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > maxH) {
                maxH = sizes[i][1];
            }
        }
        return maxW * maxH;
    }
    
    public static void sort(int[][]sizes, int index) {
        int tmp = sizes[index][0];
        sizes[index][0] = sizes[index][1];
        sizes[index][1] = tmp;
    }
}