import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s;
    int total = 0;
    Map<String, Integer> map = new HashMap<>();
    while ((s = bf.readLine()) != null) {
      // 빈 문자열이면 루프 종료
      if (s.isEmpty()) {
        break;
      }
      total++;
      // map에 key 값은 입력받는 s, value 값은 key 값이 있는지를 찾아 +1
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    ArrayList<String> list = new ArrayList<>(map.keySet());

    Collections.sort(list);

    for (String key : list) {
      int value = map.get(key);
      String format = String.format("%.4f", (double) (value * 100) / total);
      System.out.println(key + " " + format);
    }

  }

}
