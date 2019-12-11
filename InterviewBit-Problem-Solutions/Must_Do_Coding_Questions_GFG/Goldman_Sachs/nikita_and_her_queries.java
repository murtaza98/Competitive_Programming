/*
Nitika recently read about XOR operation and she got obssessed with it. She has an array containing N Positive integers.
She wants to perform Q queries on the array.
In a query She gives two integers L and R.(1 based indexing).
Now, she asks what is the xor of all the elements of the array after not including the subarray ranging from L to R (both inclusive).
Nitika guarantees that in each query, The resulting array is non empty.

Input:
The First line contains an integer T, the number oftestcases.
The first line of eachtestcase contains Two integers N ,Q -the Size of the array and the number of queries respectively. 
The next Line contains N integers denoting the array.
Each of the next Q lines contains two integers L and R.

Output:
For each query Print the required answer.

Constraints:
1<=T<=10
1<= N,Q <=1e5
0<=Ai<=1e9
1<=L,R<=N

Example:
Input:
1
10 3
4 7 8 5 9 6 1 0 20 10
3 8
1 6
2 3
Output:
29
31
17

Explanation:

For the first query:  The resulting array is: (4 ,7 ,20, 10)
                     Their Xor will be: 29
For the Second query:  The resulting array is: (1, 0, 20, 10)
                     Their Xor will be: 31
For the Third query:  The resulting array is: (4, 5, 9, 6, 1,0 ,20, 10)
                     Their Xor will be: 17
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class nikita_and_her_queries {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
			int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int n = tmp[0];
			int q = tmp[1];
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		    // pre-process
		    int[] xor = new int[n];
		    xor[0] = arr[0];
		    for(int i=1;i<n;i++){
		    	xor[i] = arr[i] ^ xor[i-1];
		    }

		    while(q>0){
		    	tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    	int l = tmp[0];
		    	int r = tmp[1];

		    	int xor_upto_r = xor[r-1];
		    	int xor_upto_l = (l==1) ? 0 : xor[l-2];

		    	int xor_l_to_r = xor_upto_r ^ xor_upto_l;

		    	// NOTE that xor[n-1] will contain xor of all elements
		    	int xor_remaining = xor_l_to_r ^ xor[n-1];

		    	sb.append(xor_remaining);

		    	q--;
		    	if(q>0){
				    sb.append("\n");
				}
		    }

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}