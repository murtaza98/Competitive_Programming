/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.
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
 
int getMinDepth(TreeNode* A, int parent_depth){
    if(A->left == NULL && A->right == NULL){
        return parent_depth;
    }
    
    int left_child_depth = INT_MAX;
    int right_child_depth = INT_MAX;
    
    
    if(A->left != NULL){
        left_child_depth = getMinDepth(A->left, parent_depth+1);
    }
    
    if(A->right != NULL){
        right_child_depth = getMinDepth(A->right, parent_depth+1);
    }
    
    return min(left_child_depth, right_child_depth);
}

int Solution::minDepth(TreeNode* A) {
    return getMinDepth(A, 1);
}
