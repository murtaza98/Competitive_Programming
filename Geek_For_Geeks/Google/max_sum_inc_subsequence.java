// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0/

// nlogn solution --> https://ideone.com/CgOMQN
// the trick is to first traverse a sorted array, in this ways the inc subsequence order is maintained.
// another trick is to use fitwick tree to calculate max within index range


// this soln is n^2

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
            
            sb.append(calc_sum(arr, n));
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int calc_sum(int[] A, int n){
	    int[] dp = new int[n];
	    
	    for(int i=0;i<n;i++){
	        dp[i] = A[i];
	    }
	    
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(A[j]<A[i] && dp[i]<(dp[j]+A[i])){
	                dp[i] = dp[j] + A[i];
	            }
	        }
	    }
	    
	    int max_sum = -1;
	    
	    for(int i : dp){
	        max_sum = Math.max(max_sum, i);
	    }
	    
	    return max_sum;
	}
}