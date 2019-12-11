/*
Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null;
        ListNode tail = null;
        while(true){
            int min_idx = -1;
            int min_val = Integer.MAX_VALUE;
            for(int i=0;i<a.size();i++){
                if(a.get(i) != null){
                    if(a.get(i).val < min_val){
                        min_idx = i;
                        min_val = a.get(i).val;
                    }
                }
            }
            if(min_idx == -1){
                break;
            }else{
                ListNode new_node = new ListNode(a.get(min_idx).val);
                if(head == null){
                    head = new_node;
                    tail = new_node;
                }else{
                    tail.next = new_node;
                    tail = new_node;
                }
                a.set(min_idx, a.get(min_idx).next);
            }
        }
        return head;
    }
}
