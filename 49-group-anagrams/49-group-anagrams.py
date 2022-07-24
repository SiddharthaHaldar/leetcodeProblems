class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}
        for str in strs:
            asciis = [0] * 26
            for c in str:
                idx = ord(c) - ord('a')
                asciis[idx] = asciis[idx] + 1
            
            key = tuple(asciis)
            if (key not in d):
                d[key] = []
            
            d[key].append(str)
            
        
        res = []
        [res.append(d[key]) for key in d.keys()]
        return res
            