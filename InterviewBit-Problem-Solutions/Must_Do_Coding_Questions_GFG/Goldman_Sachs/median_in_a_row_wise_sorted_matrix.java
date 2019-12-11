/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class median_in_a_row_wise_sorted_matrix {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int r=tmp[0];
			int c=tmp[1];

            int[][] a = new int[r][c];
		    
		    for(int i=0;i<r;i++){
		        a[i] =  Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    }

            int max_ele = Integer.MIN_VALUE;
            int min_ele = Integer.MAX_VALUE;
            
            for(int i=0;i<r;i++){
                max_ele = Math.max(max_ele, a[i][c-1]);
                min_ele = Math.min(min_ele, a[i][0]);
            }
            
            int required_place = (r*c+1)/2;
            int median = -1;
            
            while(max_ele > min_ele){
                int mid = (max_ele+min_ele)/2;
                int c_place = 0;
                for(int i=0;i<r;i++){
                    int pos = binary_search(a[i], mid);// no of elements less than mid
                    c_place+=pos;
                }
                
                if(c_place<required_place){
                    min_ele = mid+1;
                }else{
                    max_ele = mid;
                }
            }
            
            
            sb.append(min_ele);
            
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static int binary_search(int[] a, int ele){
	    int l=0, h=a.length-1;
	    while(l<=h){
	        int mid = (l+h)/2;
	        if(a[mid]==ele){
	            return mid+1;
	        }else if(a[mid] < ele){
	            l=mid+1;
	        }else{
	            h=mid-1;
	        }
	    }
	    return l;
	}
}