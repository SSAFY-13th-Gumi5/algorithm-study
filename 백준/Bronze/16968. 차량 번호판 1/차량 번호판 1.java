import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String input=sc.nextLine();

        char[] arr=input.toCharArray();
        int result=1;

        for(int i=0; i<arr.length;i++){
            if(arr[i]=='d'){
                if(i==0){
                    result*=10;
                }else{
                    if(arr[i-1]=='d'){
                        result*=9;
                    }else{
                        result*=10;
                    }
                }

            }else{
                if(i==0){
                    result*=26;
                }else{
                    if(arr[i-1]=='c'){
                        result*=25;
                    }else{
                        result*=26;
                    }
                }
            }
        }
        System.out.println(result);

    }
}
