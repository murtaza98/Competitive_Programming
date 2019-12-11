/*
Given an array of positive integers. The task is to find inversion count of array.

Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains N elements.

Output:
Print the inversion count of array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ C ≤ 1018

Example:
Input:
1
5
2 4 1 3 5

Output:
3

Explanation:
Testcase 1: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
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
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            long inversions = mergeSort(arr, 0, n-1);
            
            sb.append(inversions);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static long mergeSort(int[] arr, int l, int h){
	    if(l<h){
	        int mid = (l+h)/2;
	        
	        long inversions = mergeSort(arr, l, mid);
	        inversions += mergeSort(arr, mid+1, h);
	        
	        inversions += merge(arr, l, h, mid);
	        
	        return inversions;
	    }
	    
	    return 0;
	}
	
	static long merge(int[] a, int l, int h, int m){
	    int n1 = m-l+1;
	    int n2 = h-m;
	    
	    int[] la = new int[n1];
	    int[] ra = new int[n2];
	    
	    System.arraycopy(a, l, la, 0, n1);
	    System.arraycopy(a, m+1, ra, 0, n2);
	    
	    int la_idx=0, ra_idx=0, a_idx=l;
	    
	    long inversions=0;
	    
	    while(la_idx<n1 && ra_idx<n2){
	        if(la[la_idx] <= ra[ra_idx]){
	            a[a_idx]=la[la_idx];
	            a_idx++;
	            la_idx++;
	        }else{
	            inversions += (long)n1-la_idx;
	            
	            a[a_idx]=ra[ra_idx];
	            a_idx++;
	            ra_idx++;
	        }
	    }
	    
	    if(la_idx==n1){
	        while(ra_idx<n2){
	            a[a_idx]=ra[ra_idx];
	            a_idx++;
	            ra_idx++;
	        }
	    }
	    
	    if(ra_idx==n2){
	        while(la_idx<n1){
	            a[a_idx]=la[la_idx];
	            a_idx++;
	            la_idx++;
	        }
	    }
	    
	   // System.out.printf("%d %d %d\n", l, h, inversions);
	    
	    return inversions;
	}
}