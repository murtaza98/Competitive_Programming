/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in 
the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
void printLinked(ListNode* A){
    while(A->next!=NULL){
        cout << A->val << " -> ";
        A = A->next;
    }
    cout << A->val << endl;
}
ListNode* Solution::swapPairs(ListNode* A) {
    
    if(A == NULL || A->next == NULL){
        return A;
    }
    
    ListNode* head = A;
    
    ListNode* prev_node = NULL;
    
    while(A != NULL && A->next != NULL){
        ListNode* first_node = A;
        ListNode* second_node = A->next;
        
        first_node->next = second_node->next;
        second_node->next = first_node;
        
        if(prev_node!=NULL){
            prev_node->next = second_node;
        }else{
            // this is the head
            head = second_node;
        }
        
        prev_node = first_node;
        
        A = first_node->next;
        
        // printLinked(head);
    }
    return head;
    
}
