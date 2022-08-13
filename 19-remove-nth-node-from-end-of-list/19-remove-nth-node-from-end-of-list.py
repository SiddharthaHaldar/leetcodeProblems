# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        slow,fast = head,head
        count = 1
        prev = head
        while(count < n):
            fast = fast.next
            count += 1
            
        #print(fast.val) 
        while(fast.next):
            prev = slow
            slow = slow.next
            fast = fast.next
            #print(slow.val,fast.val)
        
        if(slow == head):
            return slow.next
        prev.next = slow.next
        slow.next = None
        return head
        
        
        