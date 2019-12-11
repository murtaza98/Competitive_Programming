/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			String[] tmp=br.readLine().trim().split("\\s+");
		    
		    int n = Integer.parseInt(tmp[0]);
		    int m = Integer.parseInt(tmp[1]);
		    
		    int[] a1 = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] a2 = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            int p1=0, p2=0;
            
            while(p1<n){
                if(a1[p1] < a2[p2]){
                    p1++;
                }else{
                    int last_a1 = a1[n-1];
                    
                    right_shift(a1, p1);
                    
                    a1[p1] = a2[p2];
                    
                    insert_in_a(a2, p2, last_a1);
                    p1++;
                }
            }
            
            for(int i=0;i<n;i++){
                sb.append(a1[i]+" ");
            }
            
            for(int i=0;i<m-1;i++){
                sb.append(a2[i]+" ");
            }
            sb.append(a2[m-1]);
            
            
 
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	public static void insert_in_a(int[] a, int p, int ele){
	    int n = a.length;
	    
	    a[p] = ele;
	    p++;
	    while(p<n){
	        if(a[p] >= a[p-1]){
	            break;
	        }
	        // swap a[p] and a[p-1]
	        int tmp = a[p];
	        a[p] = a[p-1];
	        a[p-1] = tmp;
	        p++;
	    }
	}
	
	public static void right_shift(int[] a, int p){
	    int n = a.length;
	    int c = n-1;
	    while(c!=p){
	        a[c] = a[c-1];
	        c--;
	    }
	}
}