/*
Given an unsorted array arr[] of N integers and a sum. The task is to count the number of subarrays which add to a given number.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. The next line contains N space separated integers forming the array. The last line contains an integer denoting the value of the sum.

Output:
Print the count of the subarray which adds to the given sum.

Constraints:
1 <= T <= 200
1 <= N <= 105
-105 <= arr[i] <= 105
-105 <= sum <= 105

Example:
Input:
2
5
10 2 -2 -20 10
-10
6
1 4 20 3 10 5
33

Output:
3
1

Explanation:
Testcase 1: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
 
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int ts = Integer.parseInt(br.readLine().trim()); // target_sum
            
            HashMap<Integer,Integer> sum_occ = new HashMap<>();
            
            sum_occ.put(arr[0], 1);
            int curr_sum = arr[0];
            int count = curr_sum==ts ? 1 : 0;
            
            for(int i=1;i<n;i++){
                curr_sum+=arr[i];
                // If currsum is equal to desired sum, 
                // then a new subarray is found. So 
                // increase count of subarrays. 
                if(curr_sum == ts){
                    count++;
                }
                // currsum exceeds given sum by currsum  
                //  - sum. Find number of subarrays having  
                // this sum and exclude those subarrays 
                // from currsum by increasing count by  
                // same amount. 
                if(sum_occ.containsKey(curr_sum-ts)){
                    count += sum_occ.get(curr_sum-ts);
                }
                
                // Add currsum value to count of  
                // different values of sum. 
                if(sum_occ.containsKey(curr_sum)){
                    sum_occ.put(curr_sum, sum_occ.get(curr_sum)+1);
                }else{
                    sum_occ.put(curr_sum, 1);
                }
            }
            
            sb.append(count);

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}