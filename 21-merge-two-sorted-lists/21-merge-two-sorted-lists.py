# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head,curr,prev = None,None,None
        l1ptr = list1
        l2ptr = list2
        while l1ptr and l2ptr:
            if(l1ptr.val <= l2ptr.val):
                curr = l1ptr
                l1ptr = l1ptr.next
            else:
                curr = l2ptr
                l2ptr = l2ptr.next
            if not head:
                head = curr
            if prev:
                prev.next = curr
            prev = curr
        
        if l1ptr:
            if head:
                prev.next = l1ptr
            else:
                return l1ptr
        elif l2ptr:
            if head:
                prev.next = l2ptr
            else:
                return l2ptr
        
        return head