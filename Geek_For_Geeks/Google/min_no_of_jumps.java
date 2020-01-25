// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0

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
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            sb.append(calc_jumps(arr, n));
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int calc_jumps(int[] arr, int n){
	    
	    if(n==1){
	        return 0;
	    }else if(arr[0]==0){
	        return -1;
	    }
	    
	    
	    int max_reach = arr[0];
	    int jumps = 1;
	    int steps_left = arr[0];
	    
	    for(int i=1;i<n;i++){
	        if(i==n-1){
	            return jumps;
	        }
	        if(i+arr[i]>max_reach){
	            max_reach = i+arr[i];
	        }
	        steps_left--;
	        if(steps_left==0){
	            jumps++;
                steps_left = max_reach-i;
                
                if(steps_left==0){
	                return -1;
	            }
	        }
	    }
	    
	    return -1;
	    
	}
}