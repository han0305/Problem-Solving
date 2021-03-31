/* Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well. */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode res = null;
        while(head!=null) {
            ListNode curr = head.next;
            while(curr!=null && curr.val == head.val) {
                curr = curr.next;
            }
            
            head.next = curr;
            if(res == null) 
                res = head;
            head = curr;
            
        }
        
        return res;
    }
}