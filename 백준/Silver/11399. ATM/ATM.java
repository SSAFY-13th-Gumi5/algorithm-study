

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<n;i++){
            int num=sc.nextInt();
            list.add(num);
        }
        list.sort((a,b)->a-b);

        int result=0;
        int[] sum=new int[n];
        for(int i=0; i<n; i++){
            result+=list.get(i);
            sum[i]=result;
        }
        int total=0;
        for(int i:sum){
            total+=i;
        }
        System.out.println(total);
    }
}
