# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # 1 -> 2 -> 3 -> 4 -> 5 -> 6
        # 1 -> 6 -> 2 -> 5 -> 3 -> 4
        
        # 1 -> 2 -> 3 -> 4 -> 5
        # 1 -> 5 -> 2 -> 4 -> 3
        
        #Find the middle of the linked list
        slow,fast = head,head
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        
        #After finding the mid reverse the list from AFTER the slow pointer
        ptr = slow.next
        slow.next = None
        newHead = None
        prev = None
        while(ptr):
            temp = ptr.next
            ptr.next = prev
            prev = ptr
            ptr = temp
        newHead = prev
        
        ptr = head
        ptr2 = newHead
        while(ptr):
            if(ptr2):
                temp = ptr2.next
                ptr2.next = ptr.next
                ptr.next = ptr2
                ptr2 = temp
            if(ptr.next):
                ptr = ptr.next.next
            else:
                break