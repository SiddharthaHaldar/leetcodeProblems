class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for idx,el in enumerate(nums):
            diff = target - el
            if(diff in map):
                return [map[diff],idx]
            else:
                map[el] = idx