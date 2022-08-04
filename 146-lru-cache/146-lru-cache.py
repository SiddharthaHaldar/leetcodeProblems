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
        #print('get',key)
        if(key in self.map):
            node = self.map[key]
            if(self.count > 1):
                #print(self.count)
                if(node.next == None):
                    #print('none')
                    node.prev.next = None
                    self.last = node.prev
                    node.prev = None
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                elif(node.next != None and node.prev != None):
                    #print('none,none')
                    node.prev.next = node.next
                    node.next.prev = node.prev
                    node.prev = None
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                    
            #print(self.head.val,self.last.val)
            #print(self.map.keys(),self.head.key,self.last.key)
            trav =self.head
            '''while(trav):
                print(trav.key,end = ' ')
                trav = trav.next
            print("\n")'''
            return node.val
        else:
            #print("\n")
            return -1

    def put(self, key: int, value: int) -> None:
        if(key in self.map):
            node = self.map[key]
            if(self.count > 1):
                if(node.next == None):
                    #print('none')
                    node.prev.next = None
                    self.last = node.prev
                    node.prev = None
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                elif(node.next != None and node.prev != None):
                    #print('none,none')
                    node.prev.next = node.next
                    node.next.prev = node.prev
                    node.prev = None
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                    
            node.val = value
            #print(self.head.val,self.last.val)
            #print('put',key,value)
            self.map[key] = node
            #print(self.map.keys(),self.head.key,self.last.key)
            trav =self.head
            '''while(trav):
                print(trav.key,end = ' ')
                trav = trav.next
            print("\n")'''
        else:
            node = Node(key,value)
            self.count += 1
            if(self.count <= self.capacity):
                if(self.head):
                    #print("NExceed,HE")
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                else:
                    #print("NExceed,HNone")
                    self.head = node
                    self.last = node
            else:
                self.count -= 1
                #print("count",self.count)
                toBeRemoved = self.last
                if(self.last.prev == None):
                    self.head = node
                    self.last = node
                else:
                    '''print("Exceeded and head not None")
                    print(self.head.val,self.last.val)'''
                    prevToLast = self.last.prev
                    #print(prevToLast.val)
                    prevToLast.next = None
                    self.last.prev = None
                    self.last = prevToLast
                    node.next = self.head
                    node.next.prev = node
                    self.head = node
                del self.map[toBeRemoved.key]
            #print(self.head.val,self.last.val)
            #print(self.head.prev,self.last.next)
            #print('put',key,value)
            self.map[key] = node
            #print(self.map.keys(),self.head.key,self.last.key)
            trav = self.head
            s = ""
            '''while(trav):
                print(trav.key,end = ' ')
                trav = trav.next
            print("\n")'''



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)