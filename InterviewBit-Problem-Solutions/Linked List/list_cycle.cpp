/*
Given a linked list, return the node where the cycle begins. 
If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::detectCycle(ListNode* A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    // LOGIC:-
    // USING FLOYD CYCLE
    
    ListNode* slow = A->next;
    ListNode* fast = A->next->next;
    
    bool found = false;
    
    // detect cycle
    while(fast && fast->next && fast->next->next){
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast){
            found=true;
            break;
        }
    }
    
    if(!found){
        return NULL;
    }
    
    // // search for begin of loop
    
    // // reset slow
    // slow = A;
    // while(slow != fast){
    //     slow = slow->next;
    //     fast = fast->next;
    // }
    // // fast will now be at end of cycle, so fast->next will point to begin
    // return fast->next;
    
    
    // ANOTHER LOGIC TO SEARCH FOR BEGIN OF LOOP

 	// The selected answer gives an O(n*n) solution to find the start node of the cycle. 
 	// Here's an O(n) solution:
	// Once we find the slow A and fast B meet in the cycle, make one of them 
	// still and the other continue to go one step each time, to decide the
	// perimeter of the cycle, say, P.
	// Then we put a node at the head and let it go P steps, and put another node at the head. 
	// We advance these two nodes both one step each time, when they first meet, it's the start point of the cycle.
    
    // other method
    int P = 1; // len of cycle
    slow = slow->next;
    while(slow!=fast){
        slow = slow->next;
        P++;
    }
    
    slow = A;
    fast = A;
    
    while(P > 0){
        fast = fast->next;
        P--;
    }
    
    while(slow != fast){
        slow = slow->next;
        fast = fast->next;
    }
    
    return slow;
}
