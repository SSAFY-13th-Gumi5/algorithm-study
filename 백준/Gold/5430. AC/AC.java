import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> arr = new ArrayDeque<>();
    static int reversCount = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String cmd = br.readLine();
            int input = Integer.parseInt(br.readLine());
            String strArr = br.readLine();

            arr.clear();
            reversCount = 0;

            if (input != 0) {
                strArr = strArr.substring(1, strArr.length() - 1);
                String[] elements = strArr.split(",");

                for (String element : elements) {
                    if (!element.trim().isEmpty())
                        arr.add(Integer.parseInt(element.trim()));
                }
            }

            if (myFun(cmd, arr) == 0) {
                sb.append("[");
                if (reversCount % 2 != 0) {
                    while (!arr.isEmpty()) {
                        sb.append(arr.pollLast());
                        if (!arr.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!arr.isEmpty()) {
                        sb.append(arr.pollFirst());
                        if (!arr.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static int myFun(String cmd, Deque<Integer> arr) {
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'R') {
                reversCount++;
            } else if (cmd.charAt(i) == 'D') {
                if (arr.isEmpty()) {
                    return -1;
                }
                if (reversCount % 2 == 0) {
                    arr.pollFirst();
                } else {
                    arr.pollLast();
                }
            }
        }
        return 0;
    }
}
