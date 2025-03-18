import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)=='7'){
            sb.append("111");
        }
        else if(s.charAt(0)=='6'){
            sb.append("110");
        }
        else if(s.charAt(0)=='5'){
            sb.append("101");
        }
        else if(s.charAt(0)=='4'){
            sb.append("100");
        }
        else if(s.charAt(0)=='3'){
            sb.append("11");
        }
        else if(s.charAt(0)=='2'){
            sb.append("10");
        }
        else if(s.charAt(0)=='1'){
            sb.append("1");
        }
        else{
            sb.append("0");
        }
        for(int i =1; i < s.length(); i++){
            if(s.charAt(i)=='7'){
                sb.append("111");
            }
            else if(s.charAt(i)=='6'){
                sb.append("110");
            }
            else if(s.charAt(i)=='5'){
                sb.append("101");
            }
            else if(s.charAt(i)=='4'){
                sb.append("100");
            }
            else if(s.charAt(i)=='3'){
                sb.append("011");
            }
            else if(s.charAt(i)=='2'){
                sb.append("010");
            }
            else if(s.charAt(i)=='1'){
                sb.append("001");
            }
            else{
                sb.append("000");
            }
        }
        System.out.println(sb);
    }
}
