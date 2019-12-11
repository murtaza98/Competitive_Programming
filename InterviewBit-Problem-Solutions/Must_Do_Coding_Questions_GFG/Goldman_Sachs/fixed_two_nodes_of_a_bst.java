/*
Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.

Input Format:
First line consists of T test cases. First line of every test case consists of N, denoting number of elements in BST. Second line of every test case consists 3*N elements 2 integers and a character

Note: It is guaranteed than the given input will form BST ,except for 2 nodes that will be wrong.

Output Format:
For each testcase, in a new line, print either 0 or 1.

Your Task:
You don't need to take any input. Just complete the function correctBst() that takes node as parameter. The corrected BST will then be checked internally.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
4
10 5 L 10 8 R  5 2 L 5 20 R
5
8 3 L 8 10 R 3 1 L 3 6 R 6 7 R

Output:
1
0

Explanation:
Testcase 1:

*/


import java.util.*;
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class FixingBST
{
    static int flag = 1;
    static int c = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = n;
            if(n == 0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Node temp = null;
             for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    temp = new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                                 temp.left = new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                                 temp.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                    insert(temp, a, a1, lr);
                }
            }
            flag = 1;
            c = 0;
            GfG gfg = new GfG();
            root = gfg.correctBST(root);
            
            inorder(temp, root);
            if(c+1 == m)
            System.out.println(flag);
            else
            System.out.println("0");
            
        }
    }
    
    public static void insert(Node root, int a, int a1, char lr)
    {
         if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
    public static void inorder(Node temp, Node root)
    {
        	if(flag==0){
		      return;
	}
	if(temp==null && root== null)
		return;
	if(root==null){
		flag=0;
		return;
	}
	if(temp==null){
		flag=0;
		return;
	}
	if(temp.data==root.data){
	    c++;
	}
	inorder(temp.left,root.left);
	inorder(temp.right,root.right);
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class GfG
{
    
    public Node correctBST(Node root)
    {
        // Your code here
        ArrayList<Node> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        
        Node first=null, middle=null, last=null;
        
        for(int i=1;i<inorder.size();i++){
            Node prev=inorder.get(i-1);
            Node curr=inorder.get(i);
            if(prev.data > curr.data){
                if(first==null){
                    first=prev;
                    middle=curr;
                }else{
                    last=curr;
                }
            }
        }
        
        
        Node wrong_node_1 = null, wrong_node_2 = null;
        if(last==null){
            wrong_node_1 = first;
            wrong_node_2 = middle;
        }else{
            wrong_node_1 = first;
            wrong_node_2 = last;
        }
        
        
        // EASY WAY, BUT WRONG!!
        
        // int tmp = wrong_node_1.data;
        // wrong_node_1.data = wrong_node_2.data;
        // wrong_node_2.data = tmp;
        
        
        
        
        
        // RIGHT WAY
        
        // SWAP BOTH NODES CHILDRENS
        // first swap left child
        Node tmp = wrong_node_1.left;
        wrong_node_1.left = wrong_node_2.left;
        wrong_node_2.left = tmp;
        // now swap the right childs
        tmp = wrong_node_1.right;
        wrong_node_1.right = wrong_node_2.right;
        wrong_node_2.right = tmp;
        
        
        // SWAP PARENT REFERENCES
        Node parent_wn_1 = getParent(root, wrong_node_1);
        Node parent_wn_2 = getParent(root, wrong_node_2);
        
        if(parent_wn_1 == parent_wn_2){
            // swap both childs, bcs both wrong node share same parent
            parent_wn_1.left = wrong_node_2;
            parent_wn_1.right = wrong_node_1;
        }else{
            // swap first node
            if(parent_wn_1.left!=null && parent_wn_1.left==wrong_node_1){
                parent_wn_1.left = wrong_node_2;
            }else{
                parent_wn_1.right = wrong_node_2;
            }
            
            // swap second node
            if(parent_wn_2.left!=null && parent_wn_2.left==wrong_node_2){
                parent_wn_2.left = wrong_node_1;
            }else{
                parent_wn_2.right = wrong_node_1;
            }
        }
        return root;
    }
    
    
    static Node getParent(Node root, Node target){
        if(root==null){
            return null;
        }
        
        if(root.left!=null && root.left == target){
            return root;
        }else{
            Node check = getParent(root.left, target);
            if(check!=null){
                return check;
            }
        }
        
        if(root.right!=null && root.right == target){
            return root;
        }else{
            Node check = getParent(root.right, target);
            if(check!=null){
                return check;
            }
        }
        
        return null;
    }
    
    
    
    static void inorderTraversal(Node root, ArrayList<Node> inorder){
        if(root==null){
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root);
        inorderTraversal(root.right, inorder);
    }
    
}