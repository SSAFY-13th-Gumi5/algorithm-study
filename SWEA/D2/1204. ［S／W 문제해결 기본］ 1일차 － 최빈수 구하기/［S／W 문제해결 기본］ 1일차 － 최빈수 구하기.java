//package com.ssafy.daily01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	private static int [] counter; //빈도수를 저장하는 배열
	 public static void main(String[] args) throws Exception {
	        //System.setIn(new FileInputStream("input.txt"));
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        
	        // 결과를 한 번에 출력하기 위한 StringBuilder
	        StringBuilder sb = new StringBuilder();
	        
	        int T;
	        T = Integer.parseInt(in.readLine());
	        for (int test_case = 1; test_case <= T; test_case++) {
	            sb.append("#" + test_case + " ");
	            
	            // 여러분의 알고리즘 코드 작성하기
	            /*
	             * 1. 입력 파일 객체화
	             * */
	            in.readLine();
	            String[] scores = in.readLine().split(" ");
	            counter = new int[101];
	            /*
	             * 2. 알고리즘 풀기
	             * */
	            for(int i =0; i < scores.length; i ++) {
	            	int num = Integer.parseInt(scores[i]);
	            	counter[num]++;
	            }
	            
	            /*
	             * 3. 정답 출력
	             * */
	            int answer = -1;
	            int idx = -1;
	            for(int i=0; i < counter.length; i ++) {
	            	if(answer <= counter[i]) {
	            		answer = counter[i];
	            		idx = i;
	            	}
	            }
	            sb.append(idx +"\n");
	            
	        }
	        
	        System.out.println(sb);
	    }
}
