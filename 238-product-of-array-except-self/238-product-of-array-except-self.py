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
        
        for x in range(1,len(nums)):
            res[x] = nums[x] * res[x-1]
            
        for x in range(len(nums)-2,-1,-1):
            #print(nums[x],nums[x+1])
            nums[x] = nums[x] * nums[x+1]
            
        #print(res)
        #print(nums)
        
        nums[0] = nums[1]
        
        for x in range(1,len(nums)):
            if(x == len(nums) - 1):
                nums[x] = res[x-1]
            else:
                nums[x] = res[x-1] * nums[x+1]
        
        return nums
           