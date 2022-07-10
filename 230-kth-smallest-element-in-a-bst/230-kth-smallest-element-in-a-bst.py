# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        c = 0
        val = None
        def inorder(root):
            nonlocal c,val
            if(root.left):
                inorder(root.left)
            c += 1
            if(c == k):
                val = root.val
            if(root.right and not val):
                inorder(root.right)
        inorder(root)
        return val