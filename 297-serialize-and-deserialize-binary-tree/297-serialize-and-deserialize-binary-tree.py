# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        ser = ""
        if(root):
            q = deque([])
            q.append(root)
            while(len(q) != 0):
                l = len(q)
                for x in range(0,l):
                    node = q.popleft()
                    if(node):
                        q.append(node.left)
                        q.append(node.right)
                        ser += str(node.val)
                        ser += ","
                    else:
                        ser += "#,"
        #print(ser)
        return ser

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        q = deque([])
        idx = 1
        root = TreeNode()
        if(len(data) == 0):
            return None
        data = data.split(",")
        root.val = data[0]
        q.append(root)
        while(len(q) != 0):
            node = q.popleft()
            left = data[idx]
            right = data[idx + 1]
            if(left != '#'):
                newNode = TreeNode(left)
                node.left = newNode
                q.append(newNode)
            if(right != '#'):
                newNode = TreeNode(right)
                node.right = newNode
                q.append(newNode)

            idx += 2
            
        return root 
        
#1236n45nnnnnn
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))