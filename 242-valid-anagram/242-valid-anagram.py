class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        ds = {}
        for c in s:
            if(c not in ds):
                ds[c] = 0
            ds[c] = ds[c] + 1
                
        l = len(ds.keys())
        
        for c in t:
            if(c not in ds):
                return False
            else:
                ds[c] = ds[c] - 1
                if(ds[c] < 0):
                    return False
            
        return True