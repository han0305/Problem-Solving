/* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed. */

class Solution {
public:
    ListNode* getMiddleNode(ListNode* head) {
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast != NULL && fast->next != NULL) {
            fast = fast->next->next;
            slow = slow->next;
            
        }
        
        return slow;
        
    }
    ListNode* reverseHalf(ListNode* node) {
        
        ListNode* prev = NULL;
        ListNode* nxt = NULL;
        ListNode* curr = node;
        
        while(curr!=NULL) {
            
            nxt = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nxt;
            
        }
       
        return prev;
    }
    
    void reorderList(ListNode* head) {
        if(head == NULL) 
            return;
        ListNode* mid = getMiddleNode(head);
        ListNode* revHead = reverseHalf(mid->next);
        mid->next = NULL;
        ListNode* temp = head;
        while(head!=NULL && revHead!=NULL) {
            
            ListNode* temp1 = head->next;
            ListNode* temp2 = revHead->next;
            head->next = revHead;
            revHead->next = temp1;
            head = temp1;
            revHead = temp2;
        }
        
    }
};