# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        maxSum = -float(inf)  
        def helper(root):
            nonlocal maxSum
            Self = root.val
            left = 0
            right = 0
            if(root.left):
                # Remeber left sum can be NEGATIVE, so no point including that
                left = max(0,helper(root.left))
            if(root.right):
                # Remeber right sum can be NEGATIVE, so no point including that
                right = max(0,helper(root.right))
            SelfPlusLeft = Self + left
            SelfPlusRight = Self + right
            SelfPlusLeftPlusRight = Self + left + right
            maxSum = max(maxSum,left + right + Self) 
            
            return Self + max(left,right)
        helper(root)
        return maxSum