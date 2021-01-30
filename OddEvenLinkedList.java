/* Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity. */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        ListNode lastOdd = head;
        ListNode startEven = head.next;
        ListNode lastEven = head.next;
        ListNode newHead = head;
        head = head.next.next;
        while(head!=null) {
            
            ListNode temp = head.next;
            lastOdd.next = head;
            head.next = startEven;
            head = temp;
            lastOdd = lastOdd.next;
            lastEven.next = head;
            lastEven = lastEven.next;
            if(head != null) {
                head = head.next;
            }
            
        }
        return newHead;
    }
}