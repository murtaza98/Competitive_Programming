/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
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

int isValid(TreeNode* A, int min, int max){
    if(A==NULL){
        return 1;
    }
    
    //  return false if it voilates the constraint
    if(A->val < min || A->val > max){
        return 0;
    }
    
    // check in its children by updating the childs max & min respectively
    return isValid(A->left, min, A->val - 1) && isValid(A->right, A->val+1, max);
} 
 
int Solution::isValidBST(TreeNode* A) {
    if(A==NULL){
        return 0;
    }
    return isValid(A, INT_MIN, INT_MAX);
}
