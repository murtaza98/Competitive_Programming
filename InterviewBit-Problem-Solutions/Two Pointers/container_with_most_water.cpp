/*
Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
'n' vertical lines are drawn such that the two endpoints of
 line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Your program should return an integer which corresponds to the maximum 
area of water that can be contained ( Yes, we know maximum area instead of 
maximum volume sounds weird. But this is 2D plane we are working with for 
simplicity ).

 Note: You may not slant the container. 
Example :

Input : [1, 5, 4, 3]
Output : 6

Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6
Seen this question in a real interview beforeYesNo

*/


#include <cstdio>
/*
LOGIC:-
initialize one ptr at start and other at end
then in every iteration calculate area & move the lowest value line.
*/


int Solution::maxArea(vector<int> &A) {
    
    if(A.size() <= 1){
        return 0;
    }
    
    int left = 0;
    int right = A.size()-1;
    
    int max_area = INT_MIN;
    
    while(left < right){
        int base = right - left;
        int min_height = min(A[left], A[right]);
        int area = base * min_height;
        max_area = max(max_area, area);
        
        if(A[left] < A[right]){
            // left value is less than right, so move left
            left++;
        }else{
            // right value is less than left, so move right
            right--;
        }
    }
    
    
    return max_area;
    
}
