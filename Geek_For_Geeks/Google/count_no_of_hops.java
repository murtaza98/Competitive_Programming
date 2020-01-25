// https://practice.geeksforgeeks.org/problems/count-number-of-hops/0/

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
		    
            int[] dp = new int[n+1];
            
            if(n==0){
                sb.append(1);
            }else if(n==1){
                sb.append(1);
            }else if(n==2){
                sb.append(2);
            }else{
                dp[0]=1;
                dp[1]=1;
                dp[2]=2;
                
                for(int i=3;i<=n;i++){
                    dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
                }
                
                sb.append(dp[n]);    
            }
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}