# [1,2,3,4]
# [1,2,6,24]
# [24,24,12,4]


# [-1,1,2,-3,3]
# [-1,-1,-2,6,18] res
# [18,-18,-18,-9,3] nums

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        res[0] = nums[0]
        suffix = 1
        
        for x in range(1,len(nums)):
            res[x] = nums[x] * res[x-1]
            
        for x in range(len(nums)-1,0,-1):
            res[x] = res[x-1] * suffix
            suffix *= nums[x]
        
        res[0] = suffix
            
        return res
           