import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N]; 
		for(int i =0; i < N; i ++) {
			arr[i] = sc.nextInt();
		}
	
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long count =0;
		for(int i =0; i < N; i ++) {
			count ++;
			if(arr[i] - B > 0 ) {
				count += (arr[i]-B)/C;
				if((arr[i]-B)%C >0) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}

}