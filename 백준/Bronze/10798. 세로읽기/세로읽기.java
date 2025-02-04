
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        char[][] lines=new char[5][15];
        ArrayList<Integer> length=new ArrayList<>();
        String result="";

        for(int i=0; i<5; i++){
            char[] line=sc.nextLine().toCharArray();
            length.add(line.length);
            for(int j=0; j<line.length; j++){
                lines[i][j]=line[j];
            }
        }

        length.sort((a,b)->a-b);
        int max= length.get(length.size()-1);
        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(lines[j][i]!='\0') {
                    result+=String.valueOf(lines[j][i]);
                }
            }
        }

        System.out.println(result);
    }
}
