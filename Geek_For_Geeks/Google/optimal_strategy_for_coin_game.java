// https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static int[] A;
    static int N;
    static int[][] dp;
    
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			N=Integer.parseInt(br.readLine().trim());
		    
		    A = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            
            dp = new int[N][N];
            for(int[] i : dp){
                Arrays.fill(i, -1);
            }
            
            calc_moves(0, N-1);
            
            sb.append(dp[0][N-1]);
            
            // for(int[] i : dp){
            //     System.out.println(Arrays.toString(i));
            // }
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static void calc_moves(int i, int j){
	    if(i>j || j<0){
	        return;
	    }
	    
	    if(dp[i][j] != -1){
	        return;
	    }
	    
	    // base cases
	    if(i==j){
	        dp[i][j] = A[i];
	        return;
	    }else if(i==(j-1)){
	        dp[i][j] = Math.max(A[i], A[j]);
	        return;
	    }
	    
	    // user chooses ith coin
	    calc_moves(i+2, j);     // opp chooses i+1th coin
	    calc_moves(i+1, j-1);   // opp chooses jth coin
	    
	    // user chooses jth coin
	    calc_moves(i+1, j-1);   // opp chooses i+1th coin
	    calc_moves(i, j-2);     // opp chooses j-1th coin
	    
	    int ith_coin_choosen = A[i] + Math.min(get(i+2, j), get(i+1, j-1));
	    int jth_coin_choosen = A[j] + Math.min(get(i+1, j-1), get(i, j-2));
	    
	    dp[i][j] = Math.max(ith_coin_choosen, jth_coin_choosen);
	}
	
	static int get(int i, int j){
	    if(i>j || j<0){
	        return Integer.MAX_VALUE/4;
	    }else{
	        return dp[i][j];
	    }
	}
}