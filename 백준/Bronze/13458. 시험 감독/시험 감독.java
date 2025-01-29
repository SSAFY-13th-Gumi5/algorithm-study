import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int[] stuNums= new int[n];
        long total=0;
        for(int i=0; i<n;i++){
            stuNums[i]=sc.nextInt();
        }
        sc.nextLine();
        int b=sc.nextInt();
        int c=sc.nextInt();

        for(int i=0; i<n;i++){
            int rest=stuNums[i]-b;
            total+=1;
            if(rest>0){
                if(rest<=c){
                    total+=1;
                }else{
                    total+=rest/c;
                    if((int)(rest%c)!=0){
                        total+=1;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
