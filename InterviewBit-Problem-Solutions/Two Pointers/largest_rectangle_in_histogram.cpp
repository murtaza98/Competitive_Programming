#include <iostream>
#include <cstdio>
#include <vector>
#include <stack>
#include <limits.h>
#include <algorithm>

using namespace std;

/*
Find the largest rectangular area possible in a given histogram where the 
largest rectangle can be made of a number of contiguous bars.
*/

class Solution{
	public:
		int solve(std::vector<int> &v);
};

int Solution::solve(std::vector<int> &v){
	stack<int> stk;
	int i=0;

	int max_area = INT_MIN;

	while(i < v.size()){
		// If this bar is higher than the bar on top  
    	// stack, push it to stack 
		if(stk.empty() || v[i] > v[stk.top()]){
			stk.push(i);
			i++;
		}else{
			// If this bar is lower than top of stack,  
      		// then calculate area of rectangle with stack  
	      	// top as the smallest (or minimum height) bar.  
	      	// 'i' is 'right index' for the top and element  
	      	// before top in stack is 'left index'

			// v[i] < stk.top()
			int height = stk.top();
			stk.pop();
			int base = stk.empty() ? (i) : (i-1-stk.top());

			int area = base * v[height];

			if(area > max_area){
				max_area = area;
				// printf("%d %d %d\n",base, height, max_area);
			}
		}
	}

	while(!stk.empty()){
		int height = stk.top();
		stk.pop();

		int base = stk.empty() ? (i) : (i-1-stk.top());

		int area = base * v[height];

		max_area = max(max_area, area);
	}
	
	return max_area;
}


int main(){
	static const int arr[] = {6,2,5,4,5,1,6};
	vector<int> vec (arr, arr + sizeof(arr) / sizeof(arr[0]) );
	Solution soln;
	int area = soln.solve(vec);
	cout << area << endl;
	return 0;
}