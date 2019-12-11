/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.
*/

#include <bitset>
void permute(int curr_pos, int& tmp_result, vector<int> &result, int N){
    if(curr_pos == 0){
        result.push_back(tmp_result);
        return;
    }
    
    // ignore the current bit
    permute(curr_pos-1, tmp_result, result, N);
    
    // invert the current bit
    tmp_result = tmp_result ^ (1 << (curr_pos-1));
    permute(curr_pos-1, tmp_result, result, N);
}

vector<int> Solution::grayCode(int A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    vector<int> result;
    int tmp_result = 0;
    
    permute(A, tmp_result, result, A);
    
    return result;
}
