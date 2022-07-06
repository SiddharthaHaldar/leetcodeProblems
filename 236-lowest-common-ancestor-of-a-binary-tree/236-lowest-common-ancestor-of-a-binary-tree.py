# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        lca = None
        def helper(root,p,q):
            nonlocal lca
            Self = False
            left= False
            right = False
            if(root.val == p.val or root.val == q.val):
                Self = True
            if(root.left != None):
                left = helper(root.left,p,q) 
            if(lca != None):
                return False
            if(root.right != None):
                right = helper(root.right,p,q)
            if((Self and (left or right)) or (left and right)):
                lca = root
                return False
            return Self or left or right
        helper(root,p,q)
        return lca