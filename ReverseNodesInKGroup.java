/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed. */

class Solution {
    private void reverseNode(ListNode head) {
        
        ListNode nxt = null;
        ListNode prev = null;
        while(head!=null) {
            
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int count = 0;
        ListNode newHead = null;
        ListNode currHead = head;
        ListNode prev = null;
        while(head!=null) {
            count++;
            if(count == k) {
                ListNode nxt = head.next;
                head.next = null;
                reverseNode(currHead);
                if(newHead == null){
                    newHead = head;
                }
                if(prev !=null) {
                    prev.next = head;
                }
                prev = currHead;
                currHead.next = nxt;
                currHead = nxt;
                head  = nxt;
                count = 0;
            }
            else 
            head = head.next;
            
        }
        return newHead;
    }
}