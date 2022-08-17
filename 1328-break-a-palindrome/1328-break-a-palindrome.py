class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        l,r = 0,len(palindrome) - 1
        A = True
        palindrome = list(palindrome)
        if(len(palindrome) == 1):
            return ""
        while(l < r):
            if(palindrome[l] == palindrome[r] and 
               palindrome[l] != 'a' and 
               palindrome[r] != 'a'):
                palindrome[l] = 'a'
                return "".join(palindrome)
            elif(palindrome[l] != palindrome[r]):
                return ''
            l += 1
            r -= 1
        
        palindrome[len(palindrome) - 1] = 'b'
        return "".join(palindrome)