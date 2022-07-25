class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = -1 
        r = len(s)
        while(l<r):
            l += 1
            r -= 1
            while((not (ord(s[l].lower()) >= 48 and
                        ord(s[l].lower()) <= 57) and
                   not (ord(s[l].lower()) >= 97 and
                        ord(s[l].lower()) <= 122)) and
                  l <= len(s) - 1 and l < r):
                l += 1
            while((not (ord(s[r].lower()) >= 48 and
                        ord(s[r].lower()) <= 57) and
                   not (ord(s[r].lower()) >= 97 and
                        ord(s[r].lower()) <= 122)) and
                  r <= len(s) - 1 and l < r):
                r -= 1
            
            if(s[l].lower() != s[r].lower()):
                return False
                
        return True