class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque([])
        res = []
        l,r,Max = 0,1,float(-inf)
        dq.append(nums[0])
        
        while r < k:
            #print(dq)
            while dq and nums[r] > dq[-1]:
                #print(nums[r],dq)
                dq.pop()
            dq.append(nums[r])
            r += 1
        
        #print("dq",dq)
        res.append(dq[0])
        while r < len(nums):
            #print(dq)
            if(r - l == k):
                if(nums[l] == dq[0]):
                    dq.popleft()
                l += 1
            while(dq and nums[r] > dq[-1]):
                dq.pop()
            dq.append(nums[r])
            res.append(dq[0])
            r += 1
        
        return res
        
        
        