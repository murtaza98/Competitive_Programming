/*
Given an array arr[] of N numbers. The task is to print only those numbers whose digits are from set {1,2,3}.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an integer N and the second line contains N space separated array elements.

Output:
For each test case, In new line print the required elements in increasing order. if there is no such element present in the array print "-1".

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
3
3
4 6 7
4
1 2 3 4
5
12 111 34 13 55

Output:
-1
1 2 3
12 13 111

Explanation:
Testcase 1: No elements are there in the array which contains digits 1, 2 or 3.

Testcase 2: 1, 2 and 3 are the only elements in the array which conatins digits as 1, 2 or 3.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
			int n=Integer.parseInt(br.readLine().trim());
		    int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            ArrayList<Integer> result = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                if(isValid(a[i])){
                    result.add(a[i]);
                }
            }
            
            if(result.size()==0){
                sb.append(-1);
            }else{
                Collections.sort(result);
                for(int i:result){
                    sb.append(i+" ");
                }
            }
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static boolean isValid(int n){
	    while(n!=0){
	        int rem = n%10;
	        if(rem==1 || rem==2 || rem==3){
	            n/=10;
	            continue;
	        }else{
	            // digit is not 1 or 2 or 3, so not a valid no
	            return false;
	        }
	    }
	    return true;
	}
}