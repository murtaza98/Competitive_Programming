// https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-3/0/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			char[] n=br.readLine().trim().toCharArray();
		    
            
            int rem = 0;
            
            for(int i=0;i<n.length;i++){
                rem = (rem*2 + ctoi(n[i])) % 3;
            }
            
            sb.append(rem==0 ? 1 : 0);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int ctoi(char c){
	    return c-'0';
	}
}