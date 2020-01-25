// https://practice.geeksforgeeks.org/problems/distinct-transformations/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			String s1 = br.readLine().trim();
			String s2 = br.readLine().trim();
			
			int[][] dp = new int[s1.length()+1][s2.length()+1];
			
			for(int i=0;i<=s1.length();i++){
			    for(int j=0;j<=s2.length();j++){
			        if(j==0){
			            dp[i][j] = 1;
			        }else if(i==0){
			            dp[i][j] = 0;
			        }else if(s1.charAt(i-1)!=s2.charAt(j-1)){
			            dp[i][j] = dp[i-1][j];
			        }else if(s1.charAt(i-1)==s2.charAt(j-1)){
			            dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			        }
			    }
			}
			
// 			for(int[] i : dp){
// 			    System.out.println(Arrays.toString(i));
// 			}
			
			sb.append(dp[s1.length()][s2.length()]);
			
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}