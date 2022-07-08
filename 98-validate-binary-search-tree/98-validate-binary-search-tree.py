# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        res = True
        val = -inf
        def traverse(root):
            nonlocal val,res
            if(root.left and res):
                traverse(root.left)
            if(val < root.val):
                val = root.val
            else:
                res = False
            if(root.right and res): 
                traverse(root.right)
        traverse(root)
        return res