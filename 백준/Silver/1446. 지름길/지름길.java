import java.io.*;
import java.util.*;

class Node{
    int start,end,distance;
    public Node(int start, int end, int distance){
        this.start=start;
        this.end = end;
        this.distance = distance;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[D+1];
        Arrays.fill(dp,10001);
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(end > D)
                continue;
            if(end-start < distance)
                continue;
            nodes.add(new Node(start,end,distance));
        }
        nodes.sort(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        int arrayIdx =0;
        int location =0;
        dp[0] = 0;
        while (location<D){
            if(arrayIdx<nodes.size()){
                Node node = nodes.get(arrayIdx);
                if(node.start == location){
                    dp[node.end] = Math.min(dp[node.end],dp[location]+node.distance);
                    arrayIdx++;
                    continue;
                }
            }
            dp[location+1] = Math.min(dp[location+1],dp[location]+1);
            location++;
        }
        System.out.println(dp[D]);
    }


}
