#include <string>
/*
Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4. 
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases 
*/


// LOGIC:-
// store sorted chars in key of the map and appropriate index in values

vector<vector<int> > Solution::anagrams(const vector<string> &A) {
    map<string, vector<int>> hash_table;
    
    for(int i=0;i<A.size();i++){
        string chars = A[i];
        
        sort(chars.begin(), chars.end());
        
        if(hash_table.find(chars) == hash_table.end()){
            // this hash not found
            vector<int> tmp;
            tmp.push_back(i+1);

            hash_table[chars] = tmp;
        }else{
            // key already present
            hash_table[chars].push_back(i+1);
        }
    }
    
    vector<vector<int>> result;
    
    for(auto elem : hash_table){
        // cout <<  elem.first << " --> ";
        result.push_back(elem.second);
        for(int j=0;j<elem.second.size();j++){
            // cout << elem.second[j] << " ";
        }
    }
    
    return result;
    
}
