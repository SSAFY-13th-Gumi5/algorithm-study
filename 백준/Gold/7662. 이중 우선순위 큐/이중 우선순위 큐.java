
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static PriorityQueue<Integer> maxQ;
	static PriorityQueue<Integer> minQ;
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<Integer, Integer>();
			maxQ = new PriorityQueue<Integer>(new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 > o1 ? 1 : -1;
				}
			});
			minQ = new PriorityQueue<Integer>(new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 > o2 ? 1 : -1;
				}
			});
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				String oper = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (oper.equals("I")) {
					maxQ.add(num);
					minQ.add(num);
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if (num == 1) {
						while (!maxQ.isEmpty() && map.get(maxQ.peek()) == 0) {
							maxQ.poll();
						}
						if (maxQ.isEmpty())
							continue;
						int delNum = maxQ.poll();
						map.put(delNum, map.get(delNum) - 1);
					} else {

						while (!minQ.isEmpty() && map.get(minQ.peek()) == 0) {
							minQ.poll();
						}
						if (minQ.isEmpty())
							continue;
						int delNum = minQ.poll();
						map.put(delNum, map.get(delNum) - 1);
					}
				}
			}

			while (!maxQ.isEmpty() && map.get(maxQ.peek()) == 0) {
				maxQ.poll();
			}
			while (!minQ.isEmpty() && map.get(minQ.peek()) == 0) {
				minQ.poll();
			}
			if (minQ.isEmpty() || maxQ.isEmpty())
				System.out.println("EMPTY");
			else {

				System.out.println(maxQ.peek() + " " + minQ.peek());
			}

		}
	}

}
