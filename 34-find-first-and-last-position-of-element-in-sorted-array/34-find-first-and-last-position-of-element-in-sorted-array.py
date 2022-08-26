class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low,high = 0,len(nums) - 1
        start,end = -1,-1
        while(low <= high):
            mid = (low + high) // 2
            #print(mid,nums[mid])
            if(nums[mid] == target):
                if(mid == 0 or nums[mid-1] < nums[mid]):
                    start = mid
                    break
                else:
                    high = mid - 1
            elif(nums[mid] < target):
                low = mid + 1
            elif(nums[mid] > target):
                high = mid - 1
        #print("\n")  
        if(start == -1):
            return[-1,-1]
        low,high = start,len(nums) - 1
        while(low <= high):
            mid = (low + high) // 2
            #print(mid,nums[mid])
            if(nums[mid] == target):
                if(mid == len(nums) - 1 or nums[mid+1] > nums[mid]):
                    end = mid
                    break
                else:
                    low = mid + 1
            elif(nums[mid] < target):
                low = mid + 1
            elif(nums[mid] > target):
                high = mid - 1
        return [start,end]