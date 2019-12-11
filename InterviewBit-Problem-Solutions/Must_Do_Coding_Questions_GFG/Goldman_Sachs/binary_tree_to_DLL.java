/*
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

TreeToList

Input Format:
The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

Output Format:
For each testcase, in a new line, print front to end and back to end traversals of DLL.

Your Task:
You don't have to take input. Complete the function bToDLL() that takes node and head as parameter. The driver code prints the DLL both ways.

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
3 1 2 
2 1 3 
40 20 60 10 30 
30 10 60 20 40

Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
So, DLL would be 3<=>1<=>2
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
So, DLL would be 40<=>20<=>60<=>10<=>30.
 
*/
import java.util.Scanner;
import java.util.*;
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class BT_To_DLL
{
	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BT_To_DLL obj = new BT_To_DLL();
		//DLL d = new DLL();
		int t = sc.nextInt();
		while(t>0)
		{
			HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			
			Node root = null;
			
			while(n>0)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				
				Node parent = hm.get(n1);
				if(parent == null)
				{
					parent = new Node(n1);
					hm.put(n1, parent);
					if(root == null)
					{
						root = parent;
						//d.head = root;
					}
					
				}
				
				Node child = new Node(n2);
				if(lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				
				hm.put(n2,child);
			n--;
			}
			
			GfG g = new GfG();
			Node node = g.bToDLL(root);
			obj.printList(node);
		t--;
		System.out.println();
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/
// This function should convert a given Binary tree to Doubly
// Linked List
class GfG
{
    Node head;
    Node bToDLL(Node root)
    {
	    //  Your code here	
	    Stack<Node> stk = new Stack<>();
	    
	    Node head = null;
	    
	    Node prev = null;
	    
	    Node curr =  root;
	    
	    while(curr != null || !stk.isEmpty()){
	        while(curr != null){
	            stk.push(curr);
	            curr = curr.left;
	        }
	        
	        // here curr is null
	        curr = stk.pop();
	        
	        if(head == null){
	            head = new Node(curr.data);
	            prev = head;
	        }else{
	            Node new_node = new Node(curr.data);
	            prev.right = new_node;
	            new_node.left = prev;
	            prev = new_node;
	        }
	        
	        curr = curr.right;
	    }
	    
	    return head;
    }
}