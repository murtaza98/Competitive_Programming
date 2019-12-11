/**
Given an array of N integers, find the pair of integers in the array 
which have minimum XOR value. Report the minimum XOR value.

Examples : 
Input 
0 2 5 7 
Output 
2 (0 XOR 2) 
Input 
0 4 7 9 
Output 
3 (4 XOR 7)
**/


int Solution::findMinXor(vector<int> &A) {
    int min_value = INT_MAX;
    
    // SORTING APPROACH
    // IDEA -- sort array n compare consecutive pairs
    sort(A.begin(), A.end());
    
    for(int i=0;i<A.size()-1;i++){
        // min_value = min(min_value, A[i]^A[i+1]);
        if((A[i] ^ A[i+1]) < min_value){
            cout << i <<endl;
            min_value = A[i] ^ A[i-1];
        }
    }
    
    
    // BRUTE FORCE
    // for(int i=0;i<A.size()-1;i++){
    //     for(int j=i+1;j<A.size();j++){
    //         int tmp = A[i] ^ A[j];
    //         if(tmp < min_value){
    //             min_value = tmp;
    //         }
    //     }
    // }
    
    return min_value;
    
}
