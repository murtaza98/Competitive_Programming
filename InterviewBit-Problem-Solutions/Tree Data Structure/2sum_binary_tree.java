/*
Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0
*/



/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    static TreeNode c_i; // current_inorder_node
    static TreeNode c_r_i; // current_reverse_inorder_node
    static Stack<TreeNode> inorder  = new Stack<>();
    static Stack<TreeNode> r_inorder = new Stack<>(); // reverse inorder
    
    public int t2Sum(TreeNode A, int B) {
        
        // Initalize both ptr
        c_i = A;
        c_r_i = A;
        
        TreeNode inorder_next = inorder_get_next();
        TreeNode reverse_i_next = reverse_inorder_get_next();
        while(true){
           
            
            int sum = inorder_next.val + reverse_i_next.val;
            
            if(inorder_next == reverse_i_next){
                // Sum not found
                return 0;
            }else if(sum == B){
                return 1;
            }else if(sum < B){
                inorder_next = inorder_get_next();
            }else{
                // sum > B
                reverse_i_next = reverse_inorder_get_next();
            }
        }
    }
    
    static TreeNode inorder_get_next(){
        while(c_i!=null){
            inorder.push(c_i);
            c_i = c_i.left;
        }
        TreeNode curr = inorder.pop();
        c_i = curr.right;
        
        return curr;
    }
    
    static TreeNode reverse_inorder_get_next(){
        while(c_r_i!=null){
            r_inorder.push(c_r_i);
            c_r_i = c_r_i.right;
        }
        TreeNode curr = r_inorder.pop();
        c_r_i = curr.left;
        
        return curr;
    }
}
