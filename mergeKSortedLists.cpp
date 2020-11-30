/* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it. */

class Solution {
public:
    
    ListNode* mergeUtil(ListNode* h1,ListNode* h2) {
        
        ListNode* head = NULL;
        ListNode* last = NULL;
        while(h1 || h2) {
            if(h1 && h2) {
                
                if(h1->val<=h2->val) {
                    last = h1;
                    h1=h1->next;
                }
                else {
                    if(last) {
                        last->next = h2;
                        last = h2;
                    }
                    last = h2;
                    h2 = h2->next;
                    last->next = h1;
                }
               
            }
            else if(h2) {
                if(last == NULL)
                    last  = h2;
                else {
                    last->next = h2;
                    last = h2;
                    
                }
                h2 = h2->next;
                last->next = NULL;
            }
             else if(h1) {
                if(last == NULL)
                    last  = h1;
                else {
                    last->next = h1;
                    last  = h1;
                    
                }
                h1 = h1->next;
                last->next = NULL;
            }
            
             if(head == NULL)
                    head = last;
            
        }
        
        
        return head;
    
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        int l = lists.size();
        if(l == 0) {
            return NULL;
        }
        ListNode* head = lists[0];
        for(int i = 1;i<l;i++) {
            ListNode* otherHead = lists[i];
            head = mergeUtil(head,otherHead);
            
        }
        
        
        return head;
        
    }
};

