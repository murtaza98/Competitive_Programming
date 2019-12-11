/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
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
bool compare2Nodes(TreeNode* A, TreeNode* B){
    if(A == NULL && B == NULL){
        return true;    
    }
    if(A == NULL || B == NULL){
        return false;
    }
    return A->val == B->val ? true : false;
}


bool isMirror(TreeNode* A, TreeNode* B){
    if(compare2Nodes(A,B) && compare2Nodes(A,B)){
        if(A == NULL && B == NULL){
            return true;
        }else{
            return isMirror(A->left,B->right) && isMirror(A->right,B->left);    
        }
    }else{
        return false;
    }
} 

int Solution::isSymmetric(TreeNode* root) {
    if(root == NULL){
        return true;
    }
    if(root->left == NULL && root->right == NULL){
        return true;    
    }
    if(root->left == NULL || root->right == NULL){
        return false;
    }
    return isMirror(root->left, root->right);
}
