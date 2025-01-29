
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        String[] weeks={"MON","TUE","WED","THU","FRI","SAT","SUN"};
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0; i<7; i++){
            map.put(weeks[i],i);
        }

        for(int t=1; t<=T; t++) {
            int days=0;
            String input = sc.nextLine();
            int c = map.get(input);
            if(c==6){
                days=7;
            }else{
                days = 6- c;
            }
            System.out.println("#"+t+" "+days);
        }
    }
}
