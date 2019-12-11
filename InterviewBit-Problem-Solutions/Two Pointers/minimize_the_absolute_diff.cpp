/*
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/




/*
LOGIC:-
start with 3 ptr to start in each array
then after comparison increament the ptr of array 
containing the minimum number
*/


int max_3_no(int a, int b, int c){
    int ret = max(a,b);
    ret = max(ret, c);
    return ret;
}

int min_3_no(int a, int b, int c){
    int ret = min(a,b);
    ret = min(ret, c);
    return ret;
}

int Solution::solve(vector<int> &A, vector<int> &B, vector<int> &C) {
    
    int A_ptr = 0;
    int B_ptr = 0;
    int C_ptr = 0;
    
    int min_abs_diff = INT_MAX;
    
    
    while(A_ptr < A.size() && B_ptr < B.size() && C_ptr < C.size()){
        int max_no = max_3_no(A[A_ptr], B[B_ptr], C[C_ptr]);
        int min_no = min_3_no(A[A_ptr], B[B_ptr], C[C_ptr]);
        
        if(abs(max_no-min_no) < min_abs_diff){
            min_abs_diff = abs(max_no-min_no);
        }
        
        // increament array ptr with smallest no
        if(A[A_ptr] < B[B_ptr]){
            if(A[A_ptr]<C[C_ptr]){
                A_ptr++;
            }else{
                C_ptr++;
            }
        }else{
            if(B[B_ptr]<C[C_ptr]){
                B_ptr++;
            }else{
                C_ptr++;
            }
        }
    }
    
    
    return min_abs_diff;
}
