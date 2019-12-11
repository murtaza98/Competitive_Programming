// https://codeforces.com/contest/1200/problem/B

import java.util.*;
import java.lang.*;
import java.io.*;

public class block_adventure {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int[] tmp=Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int n=tmp[0];
		    long m=(long)tmp[1];
		    int k=tmp[2];
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		    boolean possible = true;

		    for(int i=0;i<n-1;i++){
		    	m += arr[i] - Math.max(0, arr[i+1]-k);
		    	if(m<0){
		    		possible = false;
		    		break;
		    	}

		    	// if(arr[i] >= arr[i+1]){
		    	// 	m += (long)((arr[i] - arr[i+1]) + k); 
		    	// }else{
		    	// 	if(arr[i+1]-arr[i] <= k){
		    	// 		// no problem, just remove extra boxes
		    	// 		m += k-(arr[i+1]-arr[i]);
		    	// 	}else{
		    	// 		// problem, add extra boxes
		    	// 		int total_min_blocks_to_put = (arr[i+1]-k) - arr[i];
		    	// 		m -= (long)total_min_blocks_to_put;
		    	// 	}
		    	// 	// int total_min_blocks_to_put = (arr[i+1]-k) - arr[i];
		    	// 	// if(total_min_blocks_to_put > 0){
		    			
		    	// 	// }
		    		
		    	// 	if(m < 0){
		    	// 		possible = false;
		    	// 		break;
		    	// 	}
		    	// }
		    }

		    if(possible){
		    	sb.append("YES");
		    }else{
		    	sb.append("NO");
		    }

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}