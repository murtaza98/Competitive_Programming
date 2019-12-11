/*
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
*/

#define MAX_CHILDS 26

struct TrieNode{
    struct TrieNode* childs[MAX_CHILDS];
    bool isEndOfWord;
};

TrieNode* newTrieNode(){
    TrieNode* new_node = new TrieNode();
    // initialize childs to NULL
    for(int i=0;i<MAX_CHILDS;i++){
        new_node->childs[i] = NULL;
        new_node->isEndOfWord = false;
    }
    return new_node;
}

void printIVector(vector<int> &v){
    for(auto c=v.begin();c!=v.end();c++){
        cout << *c << " ";
    }
    cout << endl;
}

void printSVector(vector<string> split_A){
    for(int i =0;i<split_A.size();i++){
        cout << split_A[i] << " ";
    }
    cout << endl;
}

void buildTrie(TrieNode* root, string ch){
    TrieNode* curr_node = root;
    for(int i=0; i<ch.length() ;i++){
        int child_no = ch.at(i) - 'a';
        if(curr_node->childs[child_no] == NULL){
            curr_node->childs[child_no] = newTrieNode();
        }
        curr_node = curr_node->childs[child_no];
    }
    curr_node->isEndOfWord = true;
}

void splitString(string s, vector<string> &split_A){
    string delim = "_";

    auto start = 0U;
    auto end = s.find(delim);
    while (end != string::npos)
    {
        split_A.push_back(s.substr(start, end - start));
        start = end + delim.length();
        end = s.find(delim, start);
    }
    split_A.push_back(s.substr(start, end));
}

bool compare_C(pair<int, int> a, pair<int, int> b){
    return a.first > b.first ? true : false;
}

bool check_for_GW(TrieNode* root, string ch){
    TrieNode* curr_node = root;

    for(int i=0;i<ch.size(); i++){
        int child_no = ch.at(i) - 'a';
        if(curr_node->childs[child_no] == NULL){
            return false;
        }
        curr_node = curr_node->childs[child_no];
    }
    
    return (curr_node!=NULL && curr_node->isEndOfWord==true);
}

vector<int> Solution::solve(string A, vector<string> &B) {
    
    vector<int> result;
    
    //------ split the string-------
    vector<string> split_A;
    splitString(A, split_A);
    

    // --- form trie ---
    TrieNode* root = newTrieNode();
    
    for(int i=0;i<split_A.size();i++){
        buildTrie(root, split_A[i]);    
    }
    
    // --- traverse over the main string ---
    for(int i=0;i<B.size();i++){
        vector<string> split_B;
        splitString(B[i], split_B);
        int good_word = 0;
        for(int j=0;j<split_B.size();j++){
            if(check_for_GW(root, split_B[j]) == true){
                good_word++;
            }
        }
        result.push_back(good_word);
    }
    
    // --- sort as per the result ---
    
    pair<int, int> pairt[result.size()];
    
    for(int i=0;i<result.size();i++){
        pairt[i].first = result[i];
        pairt[i].second = i;
    }
    
    stable_sort(pairt, pairt+result.size(), compare_C);
    
    for(int i=0;i<result.size();i++){
        result[i] = pairt[i].second;
    }
    
    return result;
}
