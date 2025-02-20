import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int input;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			input = Integer.parseInt(br.readLine());
			if (input != 0) {
				maxHeap.add(input);
			}
			else if (!maxHeap.isEmpty() && input == 0)
				System.out.println(maxHeap.poll());
			else {
				System.out.println(0);
			}
		}
	}

}
