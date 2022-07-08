# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        stack = []
        res = True
        def traverse(root):
            nonlocal stack,res
            #print(stack)
            if(root.left and res):
                traverse(root.left)
            if(len(stack) > 0):
                if(stack[len(stack) - 1] < root.val):
                    stack.append(root.val)
                else:
                    res = False
            else:
                stack.append(root.val)
            if(root.right and res): 
                traverse(root.right)
        traverse(root)
        return res