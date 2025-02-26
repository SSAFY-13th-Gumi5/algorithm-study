import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.xml.transform.Templates;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String>result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (set.contains(tmp))
				result.add(tmp);
		}
		System.out.println(result.size());
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) {
			bw.write(result.get(i)+ "\n");
		}
		bw.flush();
		bw.close();
	}

}
