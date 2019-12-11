/*
Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
max depth = 2.
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
int getMaxDepth(TreeNode* A, int parent_depth){
    if(A==NULL){
        return parent_depth;
    }
    
    int left_child_depth = getMaxDepth(A->left, parent_depth+1);
    int right_child_depth = getMaxDepth(A->right, parent_depth+1);
    
    return max(left_child_depth, right_child_depth);
}
 
int Solution::maxDepth(TreeNode* A) {
    
    return getMaxDepth(A,0);
    
}
