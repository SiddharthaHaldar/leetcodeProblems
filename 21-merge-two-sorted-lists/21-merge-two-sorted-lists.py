# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummyHead = ListNode(-1)
        prev = dummyHead
        l1ptr = list1
        l2ptr = list2
        while l1ptr and l2ptr:
            if(l1ptr.val <= l2ptr.val):
                prev.next = l1ptr
                l1ptr = l1ptr.next
            else:
                prev.next = l2ptr
                l2ptr = l2ptr.next
            prev = prev.next
        
        if l1ptr:
            prev.next = l1ptr
        elif l2ptr:
            prev.next = l2ptr
        
        return dummyHead.next