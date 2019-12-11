/*
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
*/
int getMaxDepth(TreeNode* A, int parent_depth){
    
    if(A == NULL){
        return parent_depth;
    }
    
    // calculate the max_depth of the child nodes
    int left_child_depth = getMaxDepth(A->left, parent_depth+1);
    int right_child_depth = getMaxDepth(A->right, parent_depth+1);
    
    // check the max_depth difference
    if(abs(left_child_depth - right_child_depth) > 1){
        // note that if we return INT_MAX then 
        // abs(left_child_depth - right_child_depth) will always be true in all parent nodes
        return INT_MAX;
    }else{
        return max(left_child_depth, right_child_depth);
    }
} 
 
int Solution::isBalanced(TreeNode* A) {
    
    int max_diff = getMaxDepth(A, 0);
    
    if(max_diff == INT_MAX){
        return 0;
    }else{
        return 1;
    }
}