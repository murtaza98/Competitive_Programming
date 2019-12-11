class Palindrome
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        //Your code here
        Stack<Integer> stk = new Stack<>();
        
        Node curr = head;
        
        while(curr!=null){
            stk.push(curr.data);
            curr=curr.next;
        }
        
        // reset head
        curr = head;
        
        while(curr!=null){
            int stk_top = stk.pop();
            if(curr.data!=stk_top){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}