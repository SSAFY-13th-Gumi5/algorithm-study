import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner sc = new Scanner(System.in);
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.isEmpty())
        break;
      // System.out.println(s);
      if (hm.containsKey(s)) {
        hm.put(s, hm.get(s) + 1);
      } else {
        hm.put(s, 1);
      }
    }
    float sum = 0.0000F;
    for (Map.Entry<String, Integer> elem : hm.entrySet()) {
      sum += elem.getValue();
    }
    HashMap<String, Double> map = new HashMap<String, Double>();
    List<String> s_arr = new ArrayList<String>();
    for (Map.Entry<String, Integer> elem : hm.entrySet()) {
      if (!s_arr.contains(elem.getKey())) {
        s_arr.add(elem.getKey());
      }
      map.put(elem.getKey(), ((float) Math.round(elem.getValue() / sum * 1000000) / 10000.0));
    }

    Collections.sort(s_arr);
    for (String s : s_arr) {
      System.out.print(s + " ");
      System.out.printf("%.4f", map.get(s));
      System.out.println();
    }

  }



}