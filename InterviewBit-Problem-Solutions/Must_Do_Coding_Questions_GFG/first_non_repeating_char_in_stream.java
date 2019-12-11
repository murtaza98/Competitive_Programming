/*
Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If no non repeating element is found print -1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the stream. Then in the next line are x characters which are inserted to the stream.

Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.

Constraints:
1 <= T <= 200
1 <= N <= 500

Example:
Input:
2
4
a a b c
3
a a c

Output:
a -1 b b
a -1 c
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
		    
		    String[] arr = br.readLine().trim().split("\\s+");
            
            HashMap<String, Integer> seen = new HashMap<>();
            
            // add first char in stream
            sb.append(arr[0]+" ");
            seen.put(arr[0], 1);
            
            int ns_c=0;    // non-seen char
            
            for(int i=1;i<n;i++){
                if(seen.containsKey(arr[i])){
                    seen.put(arr[i], seen.get(arr[i])+1);
                }else{
                    seen.put(arr[i], 1);
                }
                
                // find non-repeating char by shifting ns_c forward
                while(ns_c<=i && seen.get(arr[ns_c])>1){
                    ns_c++;    
                }
                
                
                if(ns_c == i+1){
                    // overflow, no non-repeating char found
                    sb.append(-1+" ");
                }else{
                    sb.append(arr[ns_c]+" ");
                }
            }
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}