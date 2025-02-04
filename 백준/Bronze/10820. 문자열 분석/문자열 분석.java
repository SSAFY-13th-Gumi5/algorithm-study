
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);



        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            int[] result=new int[4];
            for(char c:line.toCharArray()){
                if(Character.isAlphabetic(c)){
                   if(Character.isLowerCase(c)){
                       result[0]++;
                   }else{
                       result[1]++;
                   }
                }else if(Character.isDigit(c)){
                    result[2]++;
                }else{
                    result[3]++;
                }
            }

            for(int r:result){
                System.out.print(r+" ");
            }
            System.out.println();
        }
    }
}
