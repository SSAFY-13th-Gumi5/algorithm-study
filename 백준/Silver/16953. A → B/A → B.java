import java.io.*;
import java.util.*;

public class Main {
    static long A, B;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


       int result = bfs(A);
        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();

    }

    private static int bfs(long start){
        Queue<Long> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();  //boolean : int 밖에 되지 않으므로 HashSet 사용

        queue.offer(start);
        visited.add(start);
       
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                long current = queue.poll();
                if(current == B){
                    return depth;
                }
                
                long next1 = current * 2;
                long next2 = current * 10 +1;
                
                if(next1<= B && !visited.contains(next1)){
                    queue.offer(next1);
                    visited.add(next1);
                }

                if(next2<= B && !visited.contains(next2)){
                    queue.offer(next2);
                    visited.add(next2);
                }
            }
            depth++;
        }
        return -1;
    }
}