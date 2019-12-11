/*
Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
NOTE : You may assume 1 <= k <= Total number of nodes in BST 
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
 
int inorderTraversal(TreeNode* root, int k){
    
    stack<TreeNode*> stk;
    
    TreeNode* curr_node = root;
    
    while(!stk.empty() || curr_node!=NULL){
        
        // get leftmost node
        while(curr_node != NULL){
            stk.push(curr_node);
            curr_node = curr_node->left;
        }
        
        // current node
        curr_node = stk.top();
        stk.pop();
        k--;
        if(k==0){
            return curr_node->val;
        }
        
        // --- right node ---
        // we have visited the left tree & parent
        // so now we will move to right child
        curr_node = curr_node->right;
    }
    
    return -1;
}

int Solution::kthsmallest(TreeNode* A, int B) {
    int result;
    result = inorderTraversal(A, B);
    
    return result;
}
