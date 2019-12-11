/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input: 
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.

Output:
Print number of possible ways to make change for N cents.

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 ≤ A[i] ≤ 300

Example:
Input:
2
3
1 2 3
4
4
2 5 3 6
10

Output:
4
5

Explanation:
Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int m=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
			int n=Integer.parseInt(br.readLine().trim());
            
            int total_ways = getTotalWays(arr, n);
            
            sb.append(total_ways);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int getTotalWays(int[] coins, int sum){
	    int n=coins.length;
	    
	    int[][] table = new int[n][sum+1];
	    
	    for(int i=0;i<n;i++){
	        table[i][0]=1;
	    }
	    
	    // fill first row
	    for(int i=1;i<=sum;i++){
	        if(i%coins[0] == 0){
	            table[0][i] = 1;
	        }
	    }
	    
	    for(int i=1;i<n;i++){
	        for(int j=1;j<=sum;j++){
	            if(coins[i] > j){
	                table[i][j] = table[i-1][j];
	            }else{
	                table[i][j] = table[i-1][j] + table[i][j-coins[i]];
	            }
	        }
	    }
	    

	   // for(int i=0;i<n;i++){
	   //     System.out.println(Arrays.toString(table[i]));
	   // }
	    
	    
	    return table[n-1][sum];
	}
}