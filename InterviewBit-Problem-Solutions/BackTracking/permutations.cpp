/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
*/



void printV(vector<int> v){
    for(int i=0;i<v.size();i++){
        cout << v[i] << " ";
    }
    cout << "\n";
}
/*
LOGIC:-
fix an element at a position, remove it from A and store it in tmp & then use recursion
by increamenting the fixed_pos val. 
After this function execution is over, pop back the tmp in array n continue.
*/


void permutation(vector<int> &A, int fixed_pos, vector<int> &tmp_result, vector<vector<int>> &result, int N){
    if(fixed_pos == N){
        result.push_back(tmp_result);
        return;
    }
    for(int i=0;i<A.size();i++){
        // create new vector with newly added element at fixed_pos
        vector<int> new_tmp_result = tmp_result;
        new_tmp_result[fixed_pos] = A[i];
        
        // pop the added element above, so that it doen't get included in next pos
        int tmp_A_used = A[i];
        A.erase(A.begin()+i);
        
        permutation(A, fixed_pos+1, new_tmp_result, result, N);
        
        // insert the popped element back
        A.insert(A.begin()+i, tmp_A_used);
    }
    return;
}

vector<vector<int> > Solution::permute(vector<int> &A) {
    
    vector<vector<int>> result;
    vector<int> tmp_result;
    
    for(int i=0;i<A.size();i++){
        tmp_result.push_back(0);
    }
    
    permutation(A, 0, tmp_result, result, A.size());
    
    // cout << result.size() << endl;
    
    return result;
}
