/* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well. */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode start = null;
        ListNode last = null;
        
        while(head!=null) {
            
            ListNode prev = head;
            head = head.next;
            int count = 0;
            while(head!=null && prev.val == head.val) {
                head = head.next;
                count++;
                
            }
            if(count>0)
                continue;
            if(start == null) {
                start = prev;
                last = prev;
                last.next = null;
            }
            else {
                last.next = prev;
                last = prev;
                last.next = null;
            }
            
        }
        
        return start;
    }
}