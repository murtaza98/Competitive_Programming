#define MAX_CHARS 256

struct TrieNode{
    struct TrieNode *childs[MAX_CHARS];
    int freq;
};

TrieNode* newTrieNode(){
    TrieNode* new_node = new TrieNode;
    new_node->freq = 1;
    // initialize its childs with NULL
    for(int i=0;i<MAX_CHARS;i++){
        new_node->childs[i] = NULL;
    }
    return new_node;
}

void fillTrie(TrieNode* root, string &str){
    TrieNode* curr_node = root;
    for(int i=0;i<str.length();i++){
        int child_no = str.at(i);
        
        if(curr_node->childs[child_no]==NULL){
            curr_node->childs[child_no] = newTrieNode();
        }else{
            curr_node->childs[child_no]->freq++;
        }
        curr_node = curr_node->childs[child_no];
    }
}

string getUniquePrefix(TrieNode* root, string &str){
    TrieNode* curr_ptr = root;
    
    string prefix;
    
    for(int i=0;i<str.length();i++){
        int child_no = str.at(i);
        // add this char to result(prefix)
        string tmp_str(1, child_no);
        prefix += tmp_str;
        
        // update curr_ptr & check if its has frequency 1
        curr_ptr = curr_ptr->childs[child_no];
        
        if(curr_ptr->freq == 1){
            break;
        }
    }
    return prefix;
}

void findPrefixUtils(TrieNode* root, string prefix,int idx, vector<string> &result){
    if(root == NULL){
        return;
    }
    if(root->freq == 1){
        result.push_back(prefix);
        return;
    }
    for(int i=0;i<MAX_CHARS;i++){
        if(root->childs[i] != NULL){
            string tmp_curr_char(1, i);
            prefix = prefix.substr(0,idx) + tmp_curr_char;
            
            findPrefixUtils(root->childs[i], prefix,idx+1, result);
        }
    }
}

vector<string> Solution::prefix(vector<string> &A) {
    
    vector<string> result;
    
    TrieNode* root = newTrieNode();
    root->freq = 0;
    
    // fill Trie with input string
    for(int i=0;i<A.size();i++){
        fillTrie(root, A[i]);
    }
    
    // traverse the trie to find the unique prefix
    // for(int i=0;i<A.size();i++){
    //     string curr_prefix = getUniquePrefix(root, A[i]);
    //     result.push_back(curr_prefix);
    // }
    string start_prefix;
    findPrefixUtils(root, start_prefix,0, result);
    
    
    
    
    
    // sort(result.begin(), result.end(), getDiff);
    
    return result;
}
