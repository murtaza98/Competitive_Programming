/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
*/

void printMap(unordered_map<string,int> m){
    for(auto it=m.begin();it!=m.end();it++){
        cout << it->first << " -> " << it->second << endl;
    }
    cout << endl;
}

vector<int> Solution::findSubstring(string A, const vector<string> &B) {
    int size_B_concat = 0;
    unordered_map<string, int> hash_map;
    
    for(int i=0;i<B.size();i++){
        // calculate size of word formed by concat of all list words
        // and also update the map
        size_B_concat += B[i].length();
        hash_map[B[i]]++;
    }
    vector<int> result;
    if(size_B_concat > A.length()){
        return result;
    }
    
    int len_word = B[0].length();
    for(int i=0;i < A.size()-size_B_concat+1;i++){
        int j=i;
        
        unordered_map<string, int> tmp_hash_map(hash_map);
        
        for(;j<i+size_B_concat;j+=len_word){
            string curr_word = A.substr(j, len_word);
            
            if(tmp_hash_map.find(curr_word) == tmp_hash_map.end()){
                // different word found, so break
                break;
            }else{
                tmp_hash_map[curr_word]--;
            }
        }
        
        bool wrong_pair = false;
        
        for(auto it=tmp_hash_map.begin();it!=tmp_hash_map.end();it++){
            if(it->second == 0){
                continue;
            }else{
                wrong_pair = true;
            }
        }
        
        if(!wrong_pair){
            result.push_back(i);
        }
        
    }
    
    return result;
}
