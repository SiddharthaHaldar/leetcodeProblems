class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l,r = 0,len(numbers) - 1
        while True:
            sum = numbers[l] + numbers[r]
            if(sum == target):
                return[l+1,r+1]
            elif(sum < target):
                l += 1
            elif(sum > target):
                r -= 1
                