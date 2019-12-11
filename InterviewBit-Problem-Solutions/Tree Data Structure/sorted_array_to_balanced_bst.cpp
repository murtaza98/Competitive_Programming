/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3
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

TreeNode* insertMiddle(TreeNode* node, const vector<int> &A, int left, int right){
    int middle = (left + right) / 2;
    
    TreeNode* new_node = new TreeNode(A[middle]);
    
    if(middle != left && middle-1 >= 0){
        new_node->left = insertMiddle(new_node, A, left, middle-1);
    }else{
        new_node->left = NULL;
    }
    
    if(middle+1 <= right){ 
        new_node->right = insertMiddle(new_node, A, middle+1, right);
    }else{
        new_node->right = NULL;
    }
    
    return new_node;
    
}

TreeNode* Solution::sortedArrayToBST(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    TreeNode* root = NULL;
    
    if(A.size() == 1){
        root = new TreeNode(A[0]);
        return root;
    }
    
    int left_ptr = 0;
    int right_ptr = A.size()-1;
    
    root = insertMiddle(root, A, left_ptr, right_ptr);

    return root;
}

// TreeNode* insertNode(TreeNode* node, int key){
//     if(node == NULL){
//         return new TreeNode(key);
//     }
//     if(key < node->val){
//         node->left = insertNode(node->left, key);
//     }else if(key > node->val){
//         node->right = insertNode(node->right, key);
//     }
//     return node;
// }
