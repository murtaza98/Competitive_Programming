/*
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

int getLength(ListNode* head){
    int len = 0;
    while(head != NULL){
        len++;
        head = head->next;
    }
    return len;
} 
 
 
ListNode* Solution::insertionSortList(ListNode* A) {
    
    int anchor = 1;
    
    int len = getLength(A);
    
    if(len == 1){
        return A;
    }else{
        // sort the first 2 elements
        if(A->val > A->next->val){
            // swap
            int temp = A->val;
            A->val = A->next->val;
            A->next->val = temp;
        }
        // if len is 2 then array is already sorted now
        if(len == 2){
            return A;
        }
    }
    
    // 3rd element
    ListNode* head = A->next->next;
    
    // 2nd element
    ListNode* prev_node = A->next;
    
    while(head != NULL){
        ListNode* curr_node = head;
        prev_node->next = curr_node->next;
        
        bool placed = false;
        
        if(A->val >= curr_node->val){  // check to place in start
            // place the curr_node in start
            curr_node->next = A;
            A = curr_node;
        }else if(prev_node->val <= curr_node->val){    // check to place in last
            // place in the last
            curr_node->next = prev_node->next;
            prev_node->next = curr_node;
        }else{    // it will be placed in middle
            ListNode* tmp_head = A->next;
            ListNode* tmp_prev_node = A;
            
            while(tmp_head->val < curr_node->val){
                tmp_prev_node = tmp_head;
                tmp_head = tmp_head->next;
            }
            
            curr_node->next = tmp_prev_node->next;
            tmp_prev_node->next = curr_node;
        }
        
        prev_node = head;
        head = head->next;
    }
    
    return A;
    
}
