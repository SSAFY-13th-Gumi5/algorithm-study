import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int [] arr;
  static int [] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st
            = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    visit = new int[N];

    loop(0,M);
  }
  private static void loop(int depth, int M) {
    if (depth == M) {
      //depth 도달
      for(int i =0; i < arr.length; i ++){
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }
    for(int i =0; i < visit.length; i ++){
      if(visit[i] == 0){
        visit[i] = 1;
        arr[depth] = i +1;
        loop(depth+1, M);

        visit[i] = 0;
      }
    }

  }
}