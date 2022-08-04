class Node:
    
    def __init__(self,key : int, value : int):
        self.key,self.val = key,value
        self.next,self.prev = None,None
        
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.count = 0
        self.head = None
        self.last = None
        self.map = {}

    def get(self, key: int) -> int:
        if(key in self.map):
            node = self.map[key]
            if(self.count > 1 and self.head != node):
                if(self.last == node):
                    node.prev.next = None
                    self.last = node.prev
                else:
                    node.prev.next = node.next
                    node.next.prev = node.prev
                    
                node.prev = None
                node.next = self.head
                node.next.prev = node
                self.head = node
            trav =self.head
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if(key in self.map):
            node = self.map[key]
            if(self.count > 1 and self.head != node):
                if(self.last == node):
                    node.prev.next = None
                    self.last = node.prev
                else:
                    node.prev.next = node.next
                    node.next.prev = node.prev
                    
                node.prev = None
                node.next = self.head
                node.next.prev = node
                self.head = node
            node.val = value
            self.map[key] = node
            trav =self.head
        else:
            node = Node(key,value)
            self.count += 1
            if(self.count <= self.capacity):
                if(self.head):
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                else:
                    self.head = node
                    self.last = node
            else:
                self.count -= 1
                toBeRemoved = self.last
                if(self.last.prev == None):
                    self.head = node
                    self.last = node
                else:
                    prevToLast = self.last.prev
                    prevToLast.next = None
                    self.last.prev = None
                    self.last = prevToLast
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                del self.map[toBeRemoved.key]
            self.map[key] = node



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)