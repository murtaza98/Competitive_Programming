/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole 
linked list which is obviously an easier version of this question. 
*/
ListNode* Solution::reverseBetween(ListNode* A, int B, int C) {
    int curr_ptr = 1;
    
    ListNode* head = A;
    
    ListNode* curr_node = A;
    ListNode* prev_node = NULL;
    ListNode* next_node = NULL;
    
    bool start_is_reversed = true;
    
    // move the ptr to B
    while(curr_ptr < B){
        curr_ptr++;
        prev_node = curr_node;
        curr_node = curr_node->next;
        start_is_reversed = false;
    }
    

    // this will be the one before Bth node
    ListNode* begin_prev_node = prev_node;
    // Bth node
    ListNode* begin_node = curr_node;
    
    while(curr_ptr < C+1){
        next_node = curr_node->next;
        if(next_node == NULL && start_is_reversed == true){
            //this is the last node and start is reversed, so in reverse this will be start
            head=curr_node;
        }
        curr_node->next = prev_node;
        
        prev_node = curr_node;
        curr_node = next_node;
        
        curr_ptr++;
    }
    
    // IMP PART -- REORDER the links fo reversed portion
    if(start_is_reversed){
        head = prev_node;
        begin_node->next = curr_node;
        // cout << prev_node->val << endl;
    }else{
        begin_prev_node->next = prev_node;
        begin_node->next = curr_node;
    }
    return head;
}
