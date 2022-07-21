class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        Max = 0
        dict = {}
        for num in nums:
            dict[num] =  False
        
        for num in dict:
            count = 0
            if(not dict[num]):
                dict[num] = True
                count += 1
                num_copy = num - 1
                while num_copy in dict:
                    dict[num_copy] = True
                    count += 1
                    num_copy -= 1
                
                num_copy = num + 1
                while num_copy in dict:
                    dict[num_copy] = True
                    count += 1
                    num_copy += 1
                
                Max = max(count,Max)
        
        return Max
                
        
        