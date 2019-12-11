/*
Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.


LOGIC IMPORTANT POINT:-
FIRST put the right child on stack & then put left child,
since we want the left child to be popped first

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
vector<int> Solution::preorderTraversal(TreeNode* A) {
    stack<TreeNode*> stk;
    vector<int> result;
    
    if(A == NULL){
        return result;
    }
    
    stk.push(A);
    
    while(!stk.empty()){
        TreeNode* curr_node = stk.top();
        stk.pop();
        
        result.push_back(curr_node->val);
        
        // right child
        TreeNode* right_child = curr_node->right;
        if(right_child != NULL){
            stk.push(right_child);
        }
        
        // left child
        TreeNode* left_child = curr_node->left;
        if(left_child != NULL){
            stk.push(left_child);
        }
    }
    
    return result;
}
