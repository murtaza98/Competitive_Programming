/*
Given a Binary Tree, convert it into its mirror.
MirrorTree1            

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains number of edges. The second line contains relation between nodes.

Output Format:
For each testcase, in a new line, print inorder traversal of mirror tree.

Your Task:
You don't have to take any input. Just complete the function mirror() that takes node as paramter. The printing is done by the driver code.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

Example:
Input:
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R

Output:
2 1 3
30 10 60 20 40

Explanation:
Testcase1: The tree is
        1         (mirror)     	   1
     /      \         =>        /     \
   3       2                  2         3
The inorder of mirror is 2 1 3
Testcase2: The tree is
                           10                                      10
                        /        \           (mirror)             /  \
                     20             30            =>           30     20
                  /       \                                         /    \
               40       60                                         60    40
The inroder traversal of mirror is 30 10 60 20 40.
 
*/


//Initial Template for Java
// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Mirror_Tree
{
	 void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
	
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
		Mirror_Tree mt = new Mirror_Tree();
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
            Tree g = new Tree();
            g.mirror(root);
			mt.inOrder(root);
			System.out.println();
            t--;
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//function Template for Java
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    
   {
        data = item;
        left = right = null;
    }
} */
class Tree
{
    void mirror(Node node)
    {
	    // Your code here
	    if(node == null){
	        return;
	    }
	    if(node.left==null && node.right==null){
	        return;
	    }
	    
	    Node tmp = node.left;
	    node.left = node.right;
	    node.right = tmp;
	    
	    mirror(node.left);
	    mirror(node.right);
    }
}