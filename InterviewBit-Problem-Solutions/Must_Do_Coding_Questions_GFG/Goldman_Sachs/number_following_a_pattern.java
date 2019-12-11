/*
Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is a string, which contains only I's and D's in capital letter.

Output:
Print the minimum number following that pattern.

Constraints:
1 ≤ T ≤ 100
1 ≤ Length of String ≤ 8

Example:
Input
5
D
I
DD
IIDDD
DDIDDIID

Output
21
12
321
126543
321654798
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
            String s = br.readLine().trim();
            
            int count = 1;
            Stack<Integer> stk = new Stack<>();
            // stk.push(count++);
            
            
            
            for(int i=0;i<s.length();i++){
                switch(s.charAt(i)){
                    case 'I':
                        stk.push(count++);
                        while(!stk.isEmpty()){
                            sb.append(stk.pop());
                        }
                        // sb.append(count++);
                        break;
                    case 'D':
                        stk.push(count++);
                        break;
                }
            }
            
            stk.push(count);
            while(!stk.isEmpty()){
                sb.append(stk.pop());
            }
			
			
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}