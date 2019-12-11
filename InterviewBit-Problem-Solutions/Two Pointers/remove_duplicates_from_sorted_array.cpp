/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that 
each element appears only once and return the new length.

Note that even though we want you to return the new length, make 
sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in 
place with constant memory.

 Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 
*/


int Solution::removeDuplicates(vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    /*
    Logic:-
    use 2 ptr,
    1st ptr will point to location where the next unique element is to be placed
    2nd ptr will be increamented until be find a unique element
    */
    
    
    int i = 0;
    int j = 0;
    
    int seen_no = A[0];
    
    int duplicate = 0;
    
    while(i < A.size() && j < A.size()){
        if(A[i] == A[j]){
            if(i != j){
                duplicate++;    
            }
            j++;
        }else{
            A[i+1] = A[j];
            j++;
            i++;
        }
    }
    
    return A.size() - duplicate;
    
}
