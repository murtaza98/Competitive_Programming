/*
Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer value N denoting the amount to get change for.

Output:
Print all the denominations needed to make the change in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
1
43

Output:
4

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		int[] deno = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
            int min_coins = getMinCoins(deno, n);
            
            sb.append(min_coins);
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int getMinCoins(int[] deno, int sum){
	    int[][] table = new int[deno.length][sum+1];
	    
	    // fill first row using deno[0] --> i.e. 1 
	    for(int i=1;i<=sum;i++){
	        table[0][i] = i/deno[0];
	    }
	    
	    for(int i=1;i<deno.length;i++){
	        for(int j=1;j<=sum;j++){
	            if(deno[i]>j){
	                table[i][j] = table[i-1][j];  
	            }else{
	                table[i][j] = Math.min(table[i-1][j], table[i][j-deno[i]]+1);
	            }
	        }
	    }
	    
	    // for(int i=0;i<deno.length;i++){
	    //     System.out.println(Arrays.toString(table[i]));
	    // }
	    
	    return table[deno.length][sum];
	    
	}
}