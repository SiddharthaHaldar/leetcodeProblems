class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for x in range(0,len(s)):
            c = s[x]
            if(c == '(' or c == '{' or c == '['):
                stack.append(c)
            elif(c == ')' and stack and stack[-1] == '('):
                stack.pop()
            elif(c == '}' and stack and stack[-1] == '{'):
                stack.pop()
            elif(c == ']' and stack and stack[-1] == '['):
                stack.pop()
            else:
                return False
        
        if len(stack) == 0:
            return True
        
        return False