import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, long[]> map = new HashMap<>();
    map.put("black", new long[] {0, 1});
    map.put("brown", new long[] {1, 10});
    map.put("red", new long[] {2, 100});
    map.put("orange", new long[] {3, 1000});
    map.put("yellow", new long[] {4, 10000});
    map.put("green", new long[] {5, 100000});
    map.put("blue", new long[] {6, 1000000});
    map.put("violet", new long[] {7, 10000000});
    map.put("grey", new long[] {8, 100000000});
    map.put("white", new long[] {9, 1000000000});

    String fir = br.readLine();
    String sec = br.readLine();
    String thr = br.readLine();
    long result = (map.get(fir)[0] * 10 + map.get(sec)[0]) * map.get(thr)[1];
    System.out.println(result);

  }

}