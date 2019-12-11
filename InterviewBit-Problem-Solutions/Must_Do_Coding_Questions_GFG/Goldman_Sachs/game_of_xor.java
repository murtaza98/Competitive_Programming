/*
You are given an array A[] of size N. Now, we call the value of an array the bit-wise XOR of all elements it contains. For example, the value of the array [1,2,3] = 1^2^3. Now, Your task is to find the bit-wise XOR of the values of all sub arrays of array A. 

Example:

Input: A[] = {1,2,3} 
Output: 2
xor[1] = 1, 
xor[1, 2] = 3
xor[2, 3] = 1
xor[1, 2, 3] = 0
xor[2] = 2
xor[3] = 3
Result : 1 ^ 3 ^ 1 ^ 0 ^ 2 ^ 3 = 2

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow . Each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the bit-wise XOR of the values of all sub arrays of array A

Constraints:
1<=T<=100
1<=N<=1000
1<=A[]<=10000

Example:
Input:
2
3
1 2 3 
4
1 2 3 4
Output:
2
0

LOGIC:-

if arr is of even length, then answer is 0 since each element occurs even no of times

if arr is of odd length, then elements at odd index(1 based indexing) appears odd no of times,
hence the answer will be xor of all elements alternatively staring from 1st element.


SideNote :- element at index i appears in total (i+1)*(size_of_array - i) times 

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
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            
            if(n%2==0){
                sb.append(0);
            }else{
                int result = 0;
                for(int i=0;i<n;i+=2){
                    result ^= arr[i];
                }
                
                sb.append(result);    
            }
            
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}