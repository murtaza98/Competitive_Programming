/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
*/

vector<int> Solution::intersect(const vector<int> &A, const vector<int> &B) {
    
    // LOGIC:-
    // put one ptr to start of each array & then manipulate ptr accordingly
    // similar to merge sort, merging phase
    
    
    int A_ptr = 0;
    int B_ptr = 0;
    
    
    vector<int> result;
    
    while(A_ptr < A.size() && B_ptr < B.size()){
        if(A[A_ptr] == B[B_ptr]){
            result.push_back(A[A_ptr]);
            A_ptr++;
            B_ptr++;
        }else if(A[A_ptr] < B[B_ptr]){
            A_ptr++;
        }else if(A[A_ptr] > B[B_ptr]){
            B_ptr++;
        }
    }
    
    return result;
}
