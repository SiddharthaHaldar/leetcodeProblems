class Solution:
    def search(self, nums: List[int], target: int) -> int:
        mid = 0
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            num = nums[mid]
            if num < target:
                left = mid + 1
            elif num > target:
                right = mid - 1
            else:
                return mid
        
        return -1