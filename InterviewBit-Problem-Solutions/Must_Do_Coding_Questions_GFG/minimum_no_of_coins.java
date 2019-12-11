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
20 20 2 1

Explanation:
Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.
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
		    
		    ArrayList<Integer> coins = new ArrayList<>();
            while(n>0){
                if(n>=2000){
                    coins.add(2000);
                    n-=2000;
                }else if(n>=500){
                    coins.add(500);
                    n-=500;
                }else if(n>=200){
                    coins.add(200);
                    n-=200;
                }else if(n>=100){
                    coins.add(100);
                    n-=100;
                }else if(n>=50){
                    coins.add(50);
                    n-=50;
                }else if(n>=20){
                    coins.add(20);
                    n-=20;
                }else if(n>=10){
                    coins.add(10);
                    n-=10;
                }else if(n>=5){
                    coins.add(5);
                    n-=5;
                }else if(n>=2){
                    coins.add(2);
                    n-=2;
                }else if(n>=1){
                    coins.add(1);
                    n-=1;
                }
            }
            
            
            
            for(int i:coins){
                sb.append(i+" ");
            }
            
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}