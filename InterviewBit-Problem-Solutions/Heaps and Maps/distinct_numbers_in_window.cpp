/*
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
*/

vector<int> Solution::dNums(vector<int> &A, int K) {
    vector<int> distinct_result;
    
    if(K > A.size()){
        return distinct_result;
    }
    
    map<int,int> count_map;
    int distinct_nos = 0;
    
    // traverse through first window
    for(int i=0;i<K;i++){
        if(count_map[A[i]] == 0){
            // A[i] not found in count_map
            count_map[A[i]] = 1;
            distinct_nos ++;
        }else{
            count_map[A[i]] += 1;
        }
    }
    
    // store the first window result
    distinct_result.push_back(distinct_nos);
    
    
    // slide over next array
    for(int i=K;i<A.size();i++){
        // shift window inwards
        if(count_map[A[i-K]] == 1){
            // this was a dictinct element, so decrease count
            distinct_nos--;
        }
        count_map[A[i-K]]--;
        
        // expand window outwards
        if(count_map[A[i]] == 0){
            distinct_nos++;
        }
        count_map[A[i]]++;
        
        // store this window result
        distinct_result.push_back(distinct_nos);
    }
    
    return distinct_result;
}
