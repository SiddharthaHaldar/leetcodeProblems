# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        maxLevel = 0
        res = []
        def dfs(root,level):
            nonlocal maxLevel,res
            if(maxLevel < level):
                maxLevel = level
                res.append(root.val)
            if(root.right): 
                dfs(root.right,level + 1)
            if(root.left):
                dfs(root.left,level + 1)
        if(root):
            dfs(root,1)
        return res