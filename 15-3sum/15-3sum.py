class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
      # -4 -1 -1  0  1  2
        nums.sort()
        res = []
        for x in range(0,len(nums)-1):
            #skip if its the same number as before
            if(x == 0 or nums[x] != nums[x-1]):
                l,r = x + 1,len(nums) - 1
                target = 0 - nums[x]
                while(l < r):
                    sum = nums[l] + nums[r]
                    if(sum < target):
                        l += 1
                    elif(sum > target):
                        r -= 1
                    else:
                        res.append([nums[x],nums[l],nums[r]])
                        #look for other solutuions if avaialble,
                        #for example our problem has two solutions when 
                        #nums[x] = -1 [-1,2] and [0,1]
                        while(l < r and nums[l+1] == nums[l]):
                            l += 1
                        l += 1
                        while(l < r and nums[r-1] == nums[r]):
                            r -= 1
                        r -= 1
                    
        return res