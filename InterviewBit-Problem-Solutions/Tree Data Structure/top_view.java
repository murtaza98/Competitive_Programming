/*
You are given a pointer to the root of a binary tree. Print the top view of the binary tree. 
Top view means when you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the example below. 
You only have to complete the function. 
For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

1 Nodes in the tree  500

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top only nodes 1,2,5,6 will be visible.
*/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

	public static void topView(Node root) {
        class QueueObj{
            Node node;
            int hd; // horizontal distance

            QueueObj(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QueueObj> q = new LinkedList<>();
        TreeMap<Integer, Node> topView = new TreeMap<>();


        if(root != null){
            q.add(new QueueObj(root, 0));
        }

        while(!q.isEmpty()){
            QueueObj currObj = q.poll();

            if(!topView.containsKey(currObj.hd)){
                topView.put(currObj.hd, currObj.node);
            }

            if(currObj.node.left!=null){
                q.add(new QueueObj(currObj.node.left, currObj.hd-1));
            }

            if(currObj.node.right!=null){
                q.add(new QueueObj(currObj.node.right, currObj.hd+1));
            }
        }

        for(Map.Entry<Integer, Node> e : topView.entrySet()){
            System.out.print(e.getValue().data+" ");
        }
        
    }

	public static Node insert(Node root, int data) {