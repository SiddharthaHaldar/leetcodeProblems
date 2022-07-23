class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = {}
        buckets = []
        for num in nums:
            buckets.append([])
            if num not in d:
                d[num] = 0
            d[num] = d[num] + 1
        
        #print(buckets,d)
        for key in d.keys():
            idx = d[key] - 1
            #print(buckets[idx])
            buckets[idx].append(key)
            
        count = 0
        idx = len(buckets) - 1
        res = []
        while count < k:
            count += len(buckets[idx])
            res.extend(buckets[idx])
            idx -= 1
            #print(count,res)
        #print(buckets)
        #print(res)
        return res