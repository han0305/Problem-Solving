/* Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list. */

class Solution {
    private int addOne(ListNode head) {
        if(head == null) 
            return 1;
        int carry = addOne(head.next);
        int val = head.val+carry;
        carry  = val/10;
        val = val%10;
        head.val = val;
        return carry;
        
    }
    public ListNode plusOne(ListNode head) {
       int carry = addOne(head);
        if(carry>0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
}