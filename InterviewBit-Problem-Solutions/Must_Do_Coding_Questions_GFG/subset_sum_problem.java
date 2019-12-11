/*
Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Each test case constitutes of two lines. First line contains 'N', representing the number of elements in the set and the second line contains the elements of the set.

Output: 
Print YES if the given set can be partioned into two subsets such that the sum of elements in both subsets is equal, else print NO.

Constraints: 
1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 1000

Example:
Input:
2
4
1 5 11 5
3
1 3 5 

Output:
YES
NO

Explanation:
Testcase 1: There exists two subsets such that {1, 5, 5} and {11}.
*/

/*
C++ SOLUTION

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int dp[100][10000];

int find(int arr[],int sum,int n){
    if(n<=0&&sum!=0){
        return 0;
    }
    if(sum<0){
        return 0;
    }
    if(sum==0){
        return 1;
    }
    if(dp[n-1][sum]!=-1){
        return dp[n-1][sum];
    }
    int  ans=(find(arr,sum-arr[n-1],n-1)||find(arr,sum,n-1));
    dp[n-1][sum]=ans;
    return ans;
}
int main() {
	//code
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    int arr[n];
	    int sum=0;
	    
	    for(int i=0;i<n;i++){
	        cin>>arr[i];
	        sum+=arr[i];
	    }
	    //int dp[n+1][sum+1];
	    memset(dp,-1,sizeof(dp));
	    if(sum%2!=0){
	        cout<<"NO"<<endl;
	    }
	    else{
	        
	        int value=find(arr,sum/2,n);
	        if(value==0){
	            cout<<"NO"<<endl;
	        }
	        else{
	            cout<<"YES"<<endl;
	    }
	}
	}
}

*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static boolean[][] subset;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int sum = getSum(arr);
            
            if(sum%2!=0){
                // odd sum, so division not possible
                sb.append("NO");
            }else{
                // even sum
                int required_sum = sum/2;
                
                boolean check = checkSubsetWithSum(arr, required_sum);
                
                if(check){
                    // there exist a set with sum as 'required_sum'
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
                
                
                // if(count_subset == 2){
                //     sb.append("YES");
                // }
                
            }
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	static boolean checkSubsetWithSum(int[] a, int sum){
	    int n = a.length;
	    
	    subset = new boolean[n+1][sum+1];
	    
	    // sum = 0 is true
	    for(int i=0;i<=n;i++){
	        subset[i][0] = true;
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=sum;j++){
	            if(a[i-1] > j){
	                subset[i][j] = subset[i-1][j];
	            }else{
	                subset[i][j] = subset[i-1][j-a[i-1]] || subset[i-1][j];
	            }
	        }
	    }
	    
	    return subset[n][sum];
	}
	
	static int getSum(int[] a){
	    int sum=0;
	    for(int i=0;i<a.length;i++){
	        sum+=a[i];
	    }
	    return sum;
	}
}