class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        dict = set()
        for num in nums:
            if(num in dict):
                return True
            dict.add(num)
        return False