// https://practice.geeksforgeeks.org/problems/number-of-coins/0/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
		    
		    int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int targetSum = tmp[0];
            int n = tmp[1];

		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
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
	    
	    for(int[] i : dp){
	        Arrays.fill(i, Integer.MAX_VALUE/3);
	    }
	    
	    for(int i=0;i<n;i++){
	        dp[i][0] = 0;
	    }
	    
	    for(int i=1;i<=targetSum;i++){
	        dp[0][i] = i%A[0]==0 ? i/A[0] : Integer.MAX_VALUE/3;
	    }
	    
	    for(int i=1;i<n;i++){
	        for(int j=1;j<=targetSum;j++){
	            // exclude ith coin
	            int exclude = dp[i-1][j];
	            
	            // include ith coin
	            int include = Integer.MAX_VALUE/3;
	            if(A[i]<=j){
	                include = dp[i][j-A[i]]+1;
	            }
	            
	            dp[i][j] = Math.min(exclude, include);
	        }
	    }
	    
	    return dp[n-1][targetSum]==Integer.MAX_VALUE/3 ? -1 : dp[n-1][targetSum];
	}
}