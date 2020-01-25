// https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static boolean[][] dp;
    static int n, msum;
    
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            int sum = Arrays.stream(arr).sum();
            
            msum = (sum+1)/2;
            
            
            dp = new boolean[2][msum+1];
            
            for(int i=0;i<=1;i++){
                dp[i][0] = true;
            }
            
            for(int i=1;i<=msum;i++){
                dp[0][i] = false;
            }
            
            for(int i=1;i<=n;i++){
                for(int j=1;j<=msum;j++){
                    dp[i%2][j] = dp[(i-1)%2][j];
                    
                    if(arr[i-1]<=j){
                        dp[i%2][j] |= dp[(i-1)%2][j-arr[i-1]];
                    }
                }
            }
            
            int set_1_sum = 0;
            
            for(int i=msum;i>=0;i--){
                if(dp[n%2][i]){
                    set_1_sum = i;
                    break;
                }
            }
            

            int set_2_sum = sum - set_1_sum;
            
            int diff = Math.abs(set_1_sum - set_2_sum);
            
            sb.append(diff);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}