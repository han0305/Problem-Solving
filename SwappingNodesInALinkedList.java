/* You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed). */

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp  = head;
        int len = 0;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode swapNode1 = null;
        ListNode swapNode2 = null;
        int i = 1;
        ListNode start = head;
        while(head!=null) {
            if(i == k-1) {
                prev1 = head;
            }
            if(i == k) {
                swapNode1 = head;
            }
                
            if(i == (len-k)) {
                prev2 = head;
            }
            if(i == len-(k-1)) {
                swapNode2 = head;
            }
            i++;
            head=head.next;
       }
        
       if(prev1 == null && prev2 == null) {
           return start;
       } 
        
        
       else if(prev1 == null) {
           ListNode swapNodeNext = prev2.next.next;
           ListNode startNodeNext = start.next;
           ListNode swapNode = prev2.next;
           if(start == prev2) {
               start.next = swapNodeNext;
               swapNode.next = start;
               start = swapNode;
           }
           else {
           prev2.next = start;
           start.next = swapNodeNext;
           swapNode.next = startNodeNext;
           start = swapNode;
           }
           
       }
        else if(prev2 == null ) {
           ListNode swapNodeNext = prev1.next.next;
           ListNode startNodeNext = start.next;
           ListNode swapNode = prev1.next;
            if(start == prev1) {
               start.next = swapNodeNext;
               swapNode.next = start;
               start = swapNode;
           }
           else {
           prev1.next = start;
           start.next = swapNodeNext;
           swapNode.next = startNodeNext;
           start = swapNode;
           }
            
            
            
            
        }
       else {
           ListNode swapNodeNext = prev2.next.next;
           ListNode startNodeNext = prev1.next.next;
           ListNode swapNode = prev2.next;
           ListNode startNode = prev1.next;
           if(startNode == prev2) {
               prev1.next = swapNode;
               swapNode.next = startNode;
               startNode.next = swapNodeNext;
           }
           else if(swapNode == prev1) {
               prev2.next = startNode;
               startNode.next = swapNode;
               swapNode.next = startNodeNext;
               
           }
           else {
           prev1.next = swapNode;
           swapNode.next = startNodeNext;
           prev2.next = startNode;
           startNode.next = swapNodeNext;
           }
            
        }
        return start;
    }
}