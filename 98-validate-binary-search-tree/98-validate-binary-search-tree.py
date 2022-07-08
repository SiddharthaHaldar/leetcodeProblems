# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.res = True
        self.val = -inf
        def traverse(root):
            if(root.left and self.res):
                traverse(root.left)
            if(self.val < root.val):
                self.val = root.val
            else:
                self.res = False
            if(root.right and self.res): 
                traverse(root.right)
        traverse(root)
        return self.res