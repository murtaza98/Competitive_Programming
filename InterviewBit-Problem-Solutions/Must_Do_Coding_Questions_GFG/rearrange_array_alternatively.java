/*
Given a sorted array of positive integers. 
Your task is to rearrange the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...

Note: O(1) extra space is allowed. Also, try to modify the input array as required.
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
		    
		    int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            int min_idx = 0, max_idx = n-1;
            int max_ele = a[n-1]+1;
            
            for(int i=0;i<n;i++){
                if(i%2==1){
                    // odd idx so it will contain min element
                    a[i] += (a[min_idx]%max_ele)*max_ele;
                    min_idx++;
                }else{
                    // even idx so it will contain max element
                    a[i] += (a[max_idx]%max_ele)*max_ele;
                    max_idx--;
                }
            }
            
            
            
            for(int i=0;i<n-1;i++){
                sb.append((a[i]/max_ele)+" ");
            }
            sb.append(a[n-1]/max_ele);
            
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}