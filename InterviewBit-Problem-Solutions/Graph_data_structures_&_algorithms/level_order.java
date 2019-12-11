/*
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
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


// APPROACH 1 - Recursion using dfs, maitaining a counter as current_depth
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> lvl_order = new ArrayList<>();
        
        
        dfs(A, 0, lvl_order);
        
        return lvl_order;
        
    }
    
    void dfs(TreeNode curr_node, int curr_depth, ArrayList<ArrayList<Integer>> lvl_order){
        if(curr_node == null){
            return;
        }
        
        if(lvl_order.size() == curr_depth){
            ArrayList<Integer> new_lvl = new ArrayList<>();
            lvl_order.add(new_lvl);
        }
        
        lvl_order.get(curr_depth).add(curr_node.val);
        
        dfs(curr_node.left, curr_depth+1, lvl_order);
        dfs(curr_node.right, curr_depth+1, lvl_order);
        
    }
    
}


// APPROACH 2 - Using bfs like traversal and using queue
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        
        LinkedList<TreeNode> parent = new LinkedList<>();
        LinkedList<TreeNode> childs = new LinkedList<>();
        
        parent.add(A);
        
        ArrayList<ArrayList<Integer>> lvl_order = new ArrayList<>();
        
        do{
            ArrayList<Integer> curr_lvl = new ArrayList<>(); 
            while(parent.size()>0){
                TreeNode curr_node = parent.pollFirst();
                curr_lvl.add(curr_node.val);
                if(curr_node.left!=null)
                    childs.add(curr_node.left);
                if(curr_node.right!=null)
                    childs.add(curr_node.right);
            }
            
            if(curr_lvl.size() > 0)
                lvl_order.add(curr_lvl);
            
            parent = childs;
            childs = new LinkedList();
        }while(parent.size()>0);
        
        return lvl_order;
    }
}