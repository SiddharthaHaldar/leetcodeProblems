class MinStack:

    def __init__(self):
        self.stack = []
        self.Min = float(inf)

    def push(self, val: int) -> None:
        if(len(self.stack) == 0):
            self.Min = float(inf)
        self.Min = min(val,self.Min)
        #print(self.Min)
        self.stack.append((val,self.Min))

    def pop(self) -> None:
        self.stack.pop()
        self.Min = self.getMin()
        #print(self.stack)

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        if(len(self.stack) == 0):
            return self.Min
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()