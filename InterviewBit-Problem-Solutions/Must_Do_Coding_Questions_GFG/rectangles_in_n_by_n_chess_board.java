/*
Find total number of Rectangles (excluding squares) in a N*N cheesboard.

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N that is the side of the chessboard.


Output:

Each seperate line showing the maximum number of rectangles possible.


Constraints:

1 ≤ T ≤ 1000
1 ≤ N ≤ 10000
 

Example:

Input :

2
1
2

Output :

0
4

 

Explanation :

For n=1 there is only one square possible and no rectangles so answer will be 0. 

For n=2 there will be 2 rectangles of dimension 1*2 and 2 rectangles of dimension 2*1. So answer if 4. 
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

			int n=Integer.parseInt(br.readLine().trim());
		    
            sb.append(getRectangles(n));
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static long getRectangles(int n){
	    if(n==1){
	        return 0;
	    }
	    return (long)n*n*(n-1)+getRectangles(n-1);
	}
}