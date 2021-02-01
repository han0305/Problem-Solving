/* You are given two linked lists: list1 and list2 of sizes n and m respectively.

Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

Build the result list and return its head. */

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode head = list1;
        for(int i=1;i<a;i++) {
            list1 = list1.next;
        }
        ListNode nxt = list1.next;
        list1.next = list2;
        while(list2.next!=null)
            list2=list2.next;
        for(int i=1;i<(b-a+1);i++) {
            nxt = nxt.next;
        }
        list2.next = nxt.next;
        return head;
    }
}