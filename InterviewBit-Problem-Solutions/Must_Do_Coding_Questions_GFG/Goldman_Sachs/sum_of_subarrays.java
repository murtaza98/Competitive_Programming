/*
Given an array A with N elements , you need to find the sum all sub arrays of array A. Since the sum could be very large print the sum modulo (10^9+7).

Input :
The first line contains integer T, denoting number of test cases. The first line of each test case contains an integer N, denoting the number of elements.The second line of each test case contains N space separated integers denoting values of the array A.


Output :
Print the answer of each test case in a new line.

Constraints :
1<=T<=100
1<=N<=10^5

Example
Input :
2
3
1 2 3
2
1 3

Output :
20
8
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            // LOGIC
            // element at index i repeats (i+1) * (size_of_arr - i) in total
            // among all sub arrays
            
            long sum = 0;
            long mod = (long)Math.pow(10,9)+7;
            
            for(int i=0;i<n;i++){
                long occ = ((i+1) * (n-i)) % mod;
                sum = (sum + arr[i] * occ) % mod;
            }
            
            sb.append(sum);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}