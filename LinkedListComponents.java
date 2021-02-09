/* We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list. */

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<G.length;i++) {
            hs.add(G[i]);
        }
        
        int count = 0;
        while(head!=null) {
            if(hs.contains(head.val)) {
                count++;
                while(head!=null && hs.contains(head.val)) {
                    hs.remove(head.val);
                    head=head.next;
                }
            }
            else {
                head = head.next;
            }
        }
        return count;
    }
}