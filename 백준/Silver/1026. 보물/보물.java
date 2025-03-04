import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int[] a=new int[n];
        Object[] b=new Object[n];

        String[] line1=sc.nextLine().split(" ");
        String[] line2=sc.nextLine().split(" ");

        for(int i=0; i<n; i++){
            a[i]=Integer.parseInt(line1[i]);
            b[i]=Integer.parseInt(line2[i]);

        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int result=0;
        for(int i=0; i<n; i++){
            result+=a[i]*(int)b[i];
        }

        System.out.println(result);
    }
}