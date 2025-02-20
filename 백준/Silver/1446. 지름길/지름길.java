import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int from;
	int cost;

	public Edge(int from, int cost) {
		super();
		this.from = from;
		this.cost = cost;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N, D;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[] dp = new int[D+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i <= D; i++) {
			graph.add(new ArrayList<Edge>());
		}

		int from, to, cost;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			if(to > D) {
				continue;
			}
			
			graph.get(to).add(new Edge(from, cost));
		}
		
		dp[0] = 0;
		for(int i=1;i<=D;i++) {
			for(int j=0;j<graph.get(i).size();j++) {
				dp[i] = Math.min(dp[i], dp[graph.get(i).get(j).from] +graph.get(i).get(j).cost );
			}
			dp[i] = Math.min(dp[i], dp[i-1] + 1);
		}
		
		bw.write(dp[D]+"\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
