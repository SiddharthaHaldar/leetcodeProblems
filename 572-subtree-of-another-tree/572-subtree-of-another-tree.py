# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def dfs(root,subroot):
            left = False
            right = False
            
            def checker(root,subroot):
                res = False
                left = False
                right = False
                if(root.val == subroot.val):
                    res = True
                if(res):
                    if(root.left and subroot.left):
                        left = checker(root.left,subroot.left)
                    elif(root.left is None and subroot.left is None):
                        left = True

                    if(root.right and subroot.right):
                        right = checker(root.right ,subroot.right)
                    elif(root.right is None and subroot.right is None):
                        right = True
                return res and left and right
            
            Self = checker(root,subroot)
            
            if(not Self):
                if(root.left):
                    left = dfs(root.left,subroot)
                if(root.right):
                    right = dfs(root.right,subroot)
                    
            return Self or left or right
        return dfs(root,subRoot)