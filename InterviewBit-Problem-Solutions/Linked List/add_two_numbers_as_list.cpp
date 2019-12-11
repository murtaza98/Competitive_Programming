/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// THIS SOLUTION USE NO EXTRA MEMORY
 
int getLength(ListNode *head){
    int len = 0;
    while(head != NULL){
        len++;
        head = head->next;
    }
    return len;
} 

ListNode* Solution::addTwoNumbers(ListNode* A, ListNode* B) {
    int len_A = getLength(A);
    int len_B = getLength(B);
    
    ListNode* head_result = NULL;
    ListNode* head_other = NULL;
    
    if(len_B > len_A){
        head_result = B;
        head_other = A;
    }else{
        head_result = A;
        head_other = B;
    }
    
    ListNode* head = head_result;
    
    int carry = 0;
    
    while(head_other != NULL){
        int sum = head_result->val + head_other->val + carry;
        head_result->val = sum % 10;
        carry = (int)sum / 10;
        head_result = head_result->next;
        head_other = head_other->next;
    }
    
    if(carry != 0){
        // add carry to reamining nodes
        while(head_result->next != NULL && carry != 0){
            int sum = head_result->val + carry;
            head_result->val = sum % 10 ;
            carry = (int)sum / 10;
            head_result = head_result->next;
        }
        
        
        // more carry exists
        if(carry!=0){
            int sum = head_result->val + carry;
            head_result->val = sum % 10 ;
            carry = (int)sum / 10;
            if(carry!=0){
                // carry still exists, so create a new node
                ListNode* newNode = new ListNode(carry);
                newNode->next = NULL;
                
                head_result->next = newNode;
            }
        }
    }
    return head;
    
}
