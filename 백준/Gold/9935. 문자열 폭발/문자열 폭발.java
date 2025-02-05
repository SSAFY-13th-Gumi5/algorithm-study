import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String origin = br.readLine();
        String bomb = br.readLine();
        String rev_bomb = new StringBuilder(bomb).reverse().toString();

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> mini_stack = new ArrayDeque<>();


        for (int i = 0; i < origin.length(); i++) {
            stack.push(origin.charAt(i));

            // peek가 폭탄 문자열의 끝과 같다면 cnt+=1 and pop
            for (int j = 0; j < rev_bomb.length(); j++) {
//                System.out.println(Arrays.toString(stack.toArray()));
                if (!stack.isEmpty() && stack.peek() == rev_bomb.charAt(j)) {
                    mini_stack.push(stack.pop());
                    continue;
                }
                break;
            }
            if(mini_stack.size() == rev_bomb.length())
                mini_stack.clear();
            else {
                while(!mini_stack.isEmpty()) {
                    stack.push(mini_stack.pop());
                }
            }

//            System.out.println(Arrays.toString(stack.toArray()) + Arrays.toString(mini_stack.toArray()));
//            br.readLine();


        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // 원래 순서대로 출력해야 하므로 뒤집기
        result.reverse();


        // 결과 출력
        bw.write(result.length() == 0 ? "FRULA" : result.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}




