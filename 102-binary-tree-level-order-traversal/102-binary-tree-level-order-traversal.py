# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        level = []
        if(root):
            dq = deque([])
            dq.append(root)
            dq.append(None)
            while(True):
                node = dq.popleft() 
                if(node is not None):
                    level.append(node.val)
                    if(node.left):
                        dq.append(node.left)
                    if(node.right):
                        dq.append(node.right)
                else:
                    levels.append(level)
                    level = []
                    if(len(dq) == 0):
                        break
                    dq.append(None)
        return levels