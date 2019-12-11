/*
Given N number of square blocks. The height of each square block is 1. The task is to create a  staircase of max height using these blocks.

Note: The first stair would require only one block, the second stair would require two blocks and so on.

Input:

The first line of the input contains T i.e number of test cases. Each line of the test case contains a number  N i.e number of blocks. 

Output:

Each new line of the output contains only one single integer i.e Maximum height of staircase.

Constraints:

1<=T<=100

1<=N<=10^8

Example:

Input:

3
10
12
16

Output:

4
4
5

Explanation:

Test Case 1: the max height of the staircase that can be made from  12  blocks is 4. (A staircase of height 4 means sequence of 1,2,3,4 blocks to create a valid staircase.)
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
            // x * (x + 1) <= 2 * n
            
            sb.append(binary_search((long)n));
            
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static long binary_search(long n){
	    long target = 2*n;
	    
	    long l=0, h=target, start=0;
	    
	    while(l<=h){
	        long mid = (l+h)/2;
	        long tmp_target = mid * (mid+1);
	        
	        if(tmp_target ==  target){
	            return mid;
	        }else if(tmp_target > target){
	            h=mid-1;
	        }else{
	            l=mid+1;
	            start=mid;
	        }
	    }
	    return start;
	}
}