// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
			int w = Integer.parseInt(br.readLine().trim());
			
		    int[] values = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int[] weights = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            sb.append(calc_soln(values, weights, n, w));

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int calc_soln(int[] val, int[] weight, int N, int W){
	    int[][] dp = new int[2][W+1];
	    
	    for(int i=0;i<=N;i++){
	        for(int j=0;j<=W;j++){
	            if(i==0 || j==0){
	                dp[i%2][j] = 0;
	            }else if(weight[i-1]>j){
	                dp[i%2][j] = dp[(i-1)%2][j];
	            }else{
	                dp[i%2][j] = Math.max(dp[(i-1)%2][j], val[i-1]+dp[(i-1)%2][j-weight[i-1]]);
	            }
	        }
	    }
	    
	    return dp[N%2][W];
	}
}