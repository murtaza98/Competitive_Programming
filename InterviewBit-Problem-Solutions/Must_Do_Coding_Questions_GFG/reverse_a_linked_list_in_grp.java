/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Example:
Input:
1
8
1 2 2 4 5 6 7 8
4

Output:
4 2 2 1 8 7 6 5

Explanation:
Testcase 2: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.






This is a function problem.You only need to complete the function given below*/
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/


// RECURSIVE SOLUTION
class GfG
{
    public static Node reverse(Node head, int k)
    {
        //Your code here
        Node prev=null, curr=head, next=null;
        int cnt = 0;
        
        while(cnt<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        if(next!=null){
            head.next = reverse(next, k);
        }
        
        return prev;
    }
}


// ITERATIVE SOLUTION

class GfG
{
    public static Node reverse(Node head, int k)
    {
        //Your code here
        
        Node g_head = null, g_prev = null, curr = head;
        
        while(curr!=null){
            Node prev = null, next = null, tmp_head=curr;
            int cl = 0;
            while(cl<k && curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cl++;
            }
            if(g_head == null){
                g_head = prev;
            }
            
            if(g_prev==null){
                // for first grp
                g_prev = tmp_head;
            }else{
                g_prev.next = prev;
                g_prev = tmp_head;
            }
        }
        
        return g_head;
        
        
    }
}
