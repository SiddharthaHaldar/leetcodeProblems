# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        #print(-1 * float("inf"))
        def dfs(root,Max):
            Max = max(root.val, Max)
            #print(Max)
            if(Max == root.val):
                nonlocal count
                count += 1
                #print(root.val)
            if(root.left is not None): 
                dfs(root.left,Max)
            if(root.right is not None): 
                dfs(root.right,Max)
        
        dfs(root,-1 * float("inf"))
        return count