
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 
        String str; 

        //입력 스트림에 읽을 데이터가 남아있는지 확인하는 메서드 
        //데이터가 있으면 TRUE, 없으면 FALSE를 반환
        //이를 이용하면 EOF를 명확하게 감지하고, 불필요한 NULL 체크 없이 입력 처리할 수 있다!
        while((str = br.readLine()) != null) {
            //EOF : End of File , 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 나타내는 용어 

            char[] array = str.toCharArray();
            int UpperCount = 0;
            int LowerCount = 0;
            int NumberCount = 0;
            int SpaceCount = 0;

            for(int i = 0; i < array.length; i++) {
                    if(Character.isUpperCase(array[i])) {
                        UpperCount++;
                    }else if(Character.isLowerCase(array[i])) {
                        LowerCount++;
                    }else if(Character.isWhitespace(array[i])) {
                        SpaceCount++;
                    }else {
                        NumberCount++;
                }
            }

            bw.write(LowerCount+" "+UpperCount+" "+NumberCount+" "+SpaceCount);
            bw.newLine();

            //반목문이 끝난 후 한 번만 flush()하면, 마지막 데이터가 출력되지 않고 남아 있을 수 있다. 
            //반복문이 끝나야 flush()가 실행되므로, 입력이 끝나지 않으면 출력이 보이지 않는다. 

        }

        bw.flush();
        br.close();
        bw.close();
    }
}