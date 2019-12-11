/*
Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
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
TreeNode* Solution::flatten(TreeNode* root) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    // LOGIC:-
    // SIMILAR TO PRE-ORDER TRAVERSAL
    
    stack<TreeNode*> stk;
    
    TreeNode* prev_node = root;
    
    if(root->right != NULL){
        stk.push(root->right);
    }
    if(root->left != NULL){
        stk.push(root->left);
    }
    
    while(!stk.empty()){
        TreeNode* curr_node = stk.top();
        stk.pop();
        
        prev_node->right = curr_node;
        prev_node->left = NULL;
        
        prev_node = curr_node;
        
        if(curr_node->right != NULL){
            stk.push(curr_node->right);
        }
        
        if(curr_node->left != NULL){
            stk.push(curr_node->left);
        }
    }
    
    return root;
}
