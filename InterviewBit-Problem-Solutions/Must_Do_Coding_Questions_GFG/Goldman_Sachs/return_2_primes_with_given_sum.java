/*
Given an even number (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair. 

NOTE: A solution will always exist, read Goldbach’s conjecture. Also, solve the problem in linear time complexity, i.e., O(n).

Input:
The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll find two prime numbers.

Note: The number would always be an even number.

Output:
For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for each test case must be in a new line.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 10000

Example:
Input:
5
74
1024
66 
8
9990

Output:
3 71
3 1021
5 61
3 5
17 9973
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
            
            int[] pn = generatePrimes(n); // prime_nos
            
            
            // get Pairs with given sum
            
            int l=0, r=pn.length-1;
            
            while(true){
                if(pn[l]+pn[r] == n){
                    break;
                }else if(pn[l]+pn[r] < n){
                    l++;
                }else{
                    // pn[l]+pn[r] < n
                    r--;
                }
            }
            
            sb.append(pn[l] +" "+pn[r]);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int[] generatePrimes(int n){
	    ArrayList<Integer> result = new ArrayList<>();
	    
	    boolean[] non_primes = new boolean[n+1];
	    
	    for(int i=2;i<=n;i++){
	        if(non_primes[i]==false){
	            result.add(i);
	            
	            for(int j=i*2;j<=n;j+=i){
	                // mark as non-prime
	                non_primes[j] = true;
	            }
	        }
	    }
	    
	    return result.stream().mapToInt(Integer::intValue).toArray();
	    
	}
}