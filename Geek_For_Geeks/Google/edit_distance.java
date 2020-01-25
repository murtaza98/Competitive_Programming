// https://practice.geeksforgeeks.org/problems/edit-distance/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static int[][] dp;
    static String str1, str2;
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
		    int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int n=tmp[0], m=tmp[1];
            
            String[] tmp1 = br.readLine().trim().split("\\s+");
            
            str1 = tmp1[0];
            str2 = tmp1[1];
            
            dp=new int[n+1][m+1];
            for(int[] i : dp){
                Arrays.fill(i, -1);
            }
            
            calc_cost(n, m);
            
            sb.append(dp[n][m]);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static void calc_cost(int n, int m){
	    if(n<0 || n>str1.length() || m<0 || m>str2.length()){
	        return;
	    }
	    
	    if(dp[n][m]!=-1){
	        return;
	    }
	    
	    if(n==0){
	        dp[n][m] = m;
	        return;
	    }
	    if(m==0){
	        dp[n][m] = n;
	        return;
	    }
	    
	    if(str1.charAt(n-1)==str2.charAt(m-1)){
	        calc_cost(n-1, m-1);
	        dp[n][m] = dp[n-1][m-1];
	    }else{
	        calc_cost(n, m-1); /*insert*/
            calc_cost(n-1, m-1);    /*replace*/
            calc_cost(n-1, m); /*remove*/
	        int cost = 1 + min(dp[n][m-1], dp[n-1][m-1], dp[n-1][m]);
	                            
	        dp[n][m] = cost;
	    }
	}
	
	static int min(int x, int y, int z){
	    return Math.min(x, Math.min(y, z));
	}
}