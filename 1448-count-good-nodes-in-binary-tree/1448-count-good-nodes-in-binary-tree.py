# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        def dfs(root,Max):
            if(root is not None):
                Max = max(root.val, Max)
                if(Max == root.val):
                    nonlocal count
                    count += 1
                dfs(root.left,Max)
                dfs(root.right,Max)
        
        dfs(root,-1 * float("inf"))
        return count