import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int cnt=1;

        //거꾸로 접근하기 
        while(a!=b){
            if(b<a){
                System.out.println(-1);
                return;
            }
            if(b%10==1) b/=10;
            else if(b%2==0) b/=2;
            else{
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(cnt);


    }


}