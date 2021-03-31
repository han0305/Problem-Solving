/* Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list. */

class Solution {
    public int getDecimalValue(ListNode head) {
        
        int count = 1;
        ListNode temp = head.next;
        while(temp!=null) {
            temp = temp.next;
            count=count*2;
        }
        
        int res = 0;
        while(head!=null) {
            if(head.val==1) {
                res = res + count;
            }
            count = count/2;
            head=head.next;
        }
        
        return res;
        
    }
}