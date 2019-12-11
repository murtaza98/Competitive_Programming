/*
Input:
The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N that is the side of the chessboard.

Output:
Each seperate line showing the maximum number of squares possible.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100

Example:
Input:
2
1
2

Output:
1
5
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
		    
		    sb.append(getSquare(n));
		    
		    //  DIRECT FORMULA
		    //  (n*(n+1)*(2n+1))/6
		    
		    
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static long getSquare(int n){
	    if(n==1){
	        return 1;
	    }
	    return (long)n*n + getSquare(n-1);
	}
}