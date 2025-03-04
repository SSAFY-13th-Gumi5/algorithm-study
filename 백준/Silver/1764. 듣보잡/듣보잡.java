import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        HashSet<String> set=new HashSet<>();
        ArrayList<String> list=new ArrayList<>();
        int listen=Integer.parseInt(st.nextToken());
        int look=Integer.parseInt(st.nextToken());

        for(int i=0; i<listen; i++){
            set.add(br.readLine());
        }

        for(int i=0; i<look; i++){
            String s=br.readLine();
            if(set.contains(s)){
                list.add(s);
            }
        }

        Collections.sort(list);
        for(String s: list){
            sb.append(s).append("\n");
        }
        System.out.println(list.size());
        System.out.println(sb);
    }
}