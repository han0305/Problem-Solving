/* Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node. */

class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null)
                fast=fast.next;
        }
        return slow;
    }
}