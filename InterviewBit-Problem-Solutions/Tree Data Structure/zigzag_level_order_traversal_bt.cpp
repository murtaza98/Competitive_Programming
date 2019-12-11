/*
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
*/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
vector<vector<int> > Solution::zigzagLevelOrder(TreeNode* root) {
    vector<TreeNode*> childs;
    vector<vector<int>> result;
    
    // push root in result
    vector<int> tmp_root_result;
    tmp_root_result.push_back(root->val);
    result.push_back(tmp_root_result);
    
    // push childs of root in childs stack
    if(root->right != NULL){
        childs.push_back(root->right);
    }
    if(root->left != NULL){
        childs.push_back(root->left);
    }
    
    int lvl = 1;
    
    while(true){
        vector<TreeNode*> next_childs;
        vector<int> curr_row;
        
        // pop from childs
        int i=0;
        while(i < childs.size()){
            TreeNode* curr_child = childs[i];
            curr_row.push_back(curr_child->val);
            
            // add right child
            if(curr_child->right != NULL){
                next_childs.push_back(curr_child->right);
            }
            
            // add left child
            if(curr_child->left != NULL){
                next_childs.push_back(curr_child->left);
            }
            
            i++;
        }
        
        if(lvl % 2 == 0){
            reverse(curr_row.begin(), curr_row.end());
        }
        
        if(curr_row.size() > 0){
            result.push_back(curr_row);    
        }
        
        if(next_childs.size()==0){
            break;
        }else{
            childs.clear();
            childs = next_childs;
        }
        // clear tmp variables
        next_childs.clear();
        curr_row.clear();
        
        lvl++;
    }
    return result;
}
