// https://practice.geeksforgeeks.org/problems/coin-change/0

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
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int targetSum=Integer.parseInt(br.readLine().trim());
            
            
            sb.append(calc_ways(arr, n, targetSum));
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	
	static int calc_ways(int[] A, int n, int targetSum){
	    
	    int[][] dp = new int[n][targetSum+1];
	    
	    for(int i=0;i<n;i++){
	        dp[i][0] = 1;
	    }
	    
	    for(int i=1;i<=targetSum;i++){
	        dp[0][i] = (i%A[0])==0 ? 1 : 0;
	    }
	    
	    for(int i=1;i<n;i++){
	        for(int j=1;j<=targetSum;j++){
	            dp[i][j] = dp[i-1][j];
	            
	            if(A[i]<=j){
	                dp[i][j] += dp[i][j-A[i]];
	            }
	        }
	    }
	    
	    return dp[n-1][targetSum];
	}
}