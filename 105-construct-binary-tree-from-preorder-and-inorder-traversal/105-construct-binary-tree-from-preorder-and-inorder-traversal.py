# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''[3,9,8,6,20,15,7]
[8,9,6,3,15,20,7]

0,6  0  3

    0,2  1   1
       0,0  2  0 
       2,2  3
    4,6  '''


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        ptr = 0
        preorderDict = {}
        inorderDict = {}
        for idx,node in enumerate(preorder):
            preorderDict[node] = idx
        for idx,node in enumerate(inorder):
            inorderDict[node] = idx
        
        def helper(lLim,rLim):
            nonlocal ptr
            nodeVal = preorder[ptr]
            inorderIdx = inorderDict[nodeVal]
            node = TreeNode(nodeVal)
            ptr += 1
            if(lLim <= inorderIdx - 1 and ptr < len(preorder)):
                node.left = helper(lLim, inorderIdx - 1)
            if(rLim >= inorderIdx + 1 and ptr < len(preorder)):
                node.right = helper(inorderIdx + 1, rLim)
            return node
        
        return helper(0,len(preorder))
            
            
            
        