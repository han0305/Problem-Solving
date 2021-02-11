/* Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions. */

class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode lessHead = null;
        ListNode lastLessNode = null;
        ListNode equalHead = null;
        ListNode lastEqualNode = null;
        
        while(head!=null) {
            
            if(head.val < x) {
                if(lessHead == null) {
                    lessHead = head;
                    lastLessNode = head;
                    head = head.next;
                    lastLessNode.next = null;
                }
                else {
                    lastLessNode.next = head;
                    lastLessNode = head;
                    head = head.next;
                    lastLessNode.next = null;
                }
                
            }
            else {
                if(equalHead == null) {
                    equalHead = head;
                    lastEqualNode = head;
                    head = head.next;
                    lastEqualNode.next = null;
                }
                else {
                    lastEqualNode.next = head;
                    lastEqualNode = head;
                    head = head.next;
                    lastEqualNode.next = null;
                }
            }
        }
        
         if(lastLessNode!=null) {
            lastLessNode.next = equalHead;
            return lessHead;
        }
        return equalHead;
    }
}