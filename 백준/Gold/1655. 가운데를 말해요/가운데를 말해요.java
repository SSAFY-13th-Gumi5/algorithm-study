import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("/Users/jinu/IdeaProjects/ps/src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> leftQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> rightQ = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        bw.write(mid + "\n");
        for(int i=1;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(mid > num)
                leftQ.add(num);
            else
                rightQ.add(num);

            if(leftQ.size()+2 == rightQ.size()){
                int min = rightQ.poll();
                leftQ.add(mid);
                mid = min;
            }
            else if(leftQ.size() == rightQ.size()+2 ||leftQ.size() == rightQ.size()+1  ){
                int max = leftQ.poll();
                rightQ.add(mid);
                mid = max;
            }

            bw.write(mid + "\n");

        }


        bw.flush();
        bw.close();
        br.close();
    }


}