
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line=sc.nextLine();
        int[] al=new int[26];


        //입력값의 각 알파벳 개수 배열에 저장
        for(int i=0; i<line.length();i++){
            al[line.charAt(i)-'A']++;
        }

        int oddCnt=0;
        char oddChar=' ';
        //홀수개인 알파벳 개수 세기
        for(int i=0; i<26; i++){
            if(al[i]%2==1){
                oddCnt++;
                oddChar=(char)(i+65);
            }

            if(oddCnt>1) break;
        }
        String result="";
        if(oddCnt>1){
            result="I'm Sorry Hansoo";
        }else{
            String front="";
            String end="";

            for(int i=0; i<26; i++){
                if(al[i]>=2){ //개수가 2개 이상인 경우
                    for(int j=0; j<al[i]/2;j++){//개수의 반만 front에 붙이기
                        front+=(char)(i+65);
                    }
                }
            }
            StringBuilder sb=new StringBuilder(front);
            end=sb.reverse().toString();

            if(oddCnt==0){
                result=front+end;
            }else if(oddCnt==1){
                result=front+oddChar+end;
            }
        }
        System.out.println(result);
    }
}
