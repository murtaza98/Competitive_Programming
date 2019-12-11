/*
Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

#include<stack>

int Solution::largestRectangleArea(vector<int> &A) {
    if(A.size() == 1){
        return A[0];
    }
    
    stack<int> stk;
    
    int i = 0;
    int max_area = INT_MIN;
    
    
    while(i < A.size()){
        if(stk.empty() || A[i] >= A[stk.top()]){
            stk.push(i);
            i++;
        }else{
            // calculate the    area
            int height = A[stk.top()];
            stk.pop();
            int base = stk.empty() ? i : i-1-stk.top();

            int area = base*height;
            max_area = ::max(max_area, area);
        }
    }
    
    while(stk.empty() == false){
        // calculate the area
        int height = A[stk.top()];
        stk.pop();
        int base = stk.empty() ? i : i-1-stk.top();

        int area = base*height;
        max_area = ::max(max_area, area);
    }
    
    return max_area;
}
