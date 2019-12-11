/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
*/


void printVectorC(vector<int> a){
    for(auto i=a.begin();i!=a.end();i++){
        cout << *i << " ";
    }
    cout << endl;
}

void subset(vector<int> &A, int curr_idx, vector<int> &tmp_result, vector<vector<int>> &result){
    if(curr_idx >= A.size()){
        return;
    }
    // include current element
    tmp_result.push_back(A[curr_idx]);
    result.push_back(tmp_result);
    subset(A, curr_idx+1, tmp_result, result);
    
    // remove duplicates
    while(A[curr_idx] == A[curr_idx+1]){
        curr_idx++;
    }
    
    // exclude curr_element
    tmp_result.pop_back();
    result.push_back(tmp_result);
    subset(A, curr_idx+1, tmp_result, result);
}

vector<vector<int> > Solution::subsetsWithDup(vector<int> &A) {
    if(A.size() == 0){
        vector<vector<int>> result;
        vector<int> tmp;
        result.push_back(tmp);
        return result;
    }
    
    sort(A.begin(), A.end());
    
    vector<vector<int>> result;
    vector<int> curr;
    subset(A, 0, curr, result);
    
    // remove duplicates
    sort(result.begin(), result.end());
    result.erase( unique( result.begin(), result.end() ), result.end() );
    return result;
}
