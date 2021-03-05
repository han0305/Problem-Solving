/* You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed. */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> s1 = new ArrayDeque<>();
        ArrayDeque<Integer> s2 = new ArrayDeque<>();
        
        while(l1!=null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode last = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry>0) {
            int sum = carry;
            if(!s1.isEmpty()) {
                sum+=s1.pop();
            }
            if(!s2.isEmpty()) {
                sum+=s2.pop();
            }
            int no = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(no,last);
            last = newNode;
        }
        
        return last;
    }
}