/*
Given an array of integers, every element appears twice except for one.
Find that single one.

Note: Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
*/

int Solution::singleNumber(const vector<int> &A) {
    
    /*
    IDEA:-
    a) XOR of element with itself is zero
    b) XOR of element with 0 is itself
    c) XOR is associative and commutative
    */
    
    
    int result = 0;
    
    for(int i = 0;i<A.size();i++){
        result ^= A[i];
    }
    return result;
}
