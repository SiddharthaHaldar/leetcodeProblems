class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        arr = nums
        k = len(arr) - k + 1
        def quickSelect(low,high):
            nonlocal arr,k
            pivot = arr[high]
            ptr = low
            idx = low
            while(idx < high):
                if(arr[idx] <= pivot):
                    #swap elements at ptr and idx and move ptr by 1
                    arr[ptr],arr[idx] = arr[idx],arr[ptr]
                    ptr += 1
                idx += 1
            arr[idx],arr[ptr] = arr[ptr],arr[idx]
            #print(nums)
            if(ptr == k-1):
                return arr[ptr]
            if(ptr < k-1):
                return quickSelect(ptr + 1,high)
            if(ptr > k-1):
                return quickSelect(low,ptr - 1)
        
        return quickSelect(0,len(nums) - 1)