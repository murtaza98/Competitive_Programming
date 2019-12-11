/*
Given a singly linked list: A0→A1→…→An-1→An,
reorder it to: A0→An→A1→An-1→A2→An-2→…

Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

It is recommended do this in-place without altering the nodes' values.

Input:

In this problem, method takes one argument: Address of the head of the linked list. The function should not read any input from stdin/console.
The node structure has a data part which stores the data and a next pointer which points to the next element of the linked list. 
There are multiple test cases. For each test case, this method will be called individually.

Output:

Reorder it as explained above.

Constraints:

1<=T<=200
1<=N<=200

Example:

Input:

2
3
1 2 3
4
1 7 3 4

Output:

1 3 2
1 4 7 3
*/


import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
public class ReorderList
{
    Node head;  // head of lisl
  
    /* Linked list Node*/
   
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
     public void addToTheLast(Node node) {
  if (head == null) {
   head = node;
  } else {
   Node temp = head;
   while (temp.next != null)
    temp = temp.next;
   temp.next = node;
  }
 }
  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
    
     
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
         int t=sc.nextInt();
         while(t>0)
         {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
         }
          //int k=sc.nextInt();
         
        llist.head = new gfg().reorderlist(llist.head);
        //llist.printList();
        //llist.head = llist.reverse(llist.head);
        llist.printList();
        
        t--;
    }
}
}

/*This is a function problem.You only need to complete the function given below*/
/* Following is the Linked list node structure */
/*class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}*/
    
class gfg
{
    Node reorderlist(Node head)
    {
        // Your code here
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast.next != null){
            slow = slow.next;
        }
        
        
        Node head_2 = slow.next;
        
        // seperate both LL
        slow.next = null;
        
        // reverse new LL
        head_2 = reverseLL(head_2);
        
        Node head_1 = head;
        
        
        while(head_2 != null){
            Node tmp_head_1_next = head_1.next;
            Node tmp_head_2_next = head_2.next;
            
            head_1.next = head_2;
            
            head_2.next = tmp_head_1_next;
            
            head_1 = tmp_head_1_next;
            head_2 = tmp_head_2_next;
        }
        
        return head;
    }
    
    static Node reverseLL(Node root){
        Node prev = null, next = null, curr = root;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    static void printLL(Node root){
        while(root!=null){
            System.out.print(root.data+" -> ");
            root = root.next;
        }
        System.out.println();
    }
}