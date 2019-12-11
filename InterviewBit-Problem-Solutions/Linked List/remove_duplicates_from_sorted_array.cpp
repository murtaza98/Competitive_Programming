/*
Given a sorted linked list, delete all duplicates such that each element appear 
only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* Solution::deleteDuplicates(ListNode* A) {
    
    ListNode* head = A;
    
    
    ListNode* prev_node = A;
    A = A->next;
    
    while(A != NULL){
        if(A->val == prev_node->val){
            prev_node->next = A->next;
            A = A->next;
        }else{
            prev_node = A;
            A = A->next;
        }
    }
    
    return head;
}
