class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l,r = 0,0
        Len = len(s)
        dt,ds = defaultdict(int),defaultdict(int)
        minLen = float(inf)
        minL,minR = 0,0
        needed,have = 0,0
        for x in range(0,len(t)):
            dt[t[x]] += 1
            
        #print(dt)
        while(r < Len):
            L = s[l]
            R = s[r]
            if R in dt:
                ds[R] += 1
                if ds[R] == dt[R]:
                    have += 1
            #print(have)
            while have == len(dt.keys()):
                if (r - l + 1 < minLen):
                    minLen = r - l + 1
                    minL = l
                    minR = r
                l += 1
                if(s[l-1] in ds):
                    ds[s[l-1]] -= 1
                    if ds[s[l-1]] < dt[s[l-1]]:
                        have -=1
            
            r += 1
            
        #print(minL,minR,ds)
        return "" if minLen == float("inf") else s[minL:minR+1]
        
            
        