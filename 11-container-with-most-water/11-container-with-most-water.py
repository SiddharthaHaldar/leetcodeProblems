class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = float(-inf)
        l,r = 0,len(height) - 1
        while(l < r):
            area = (r-l) * min(height[l],height[r])
            maxArea = max(area,maxArea)
            if(height[l] > height[r]):
                r -= 1
            elif(height[l] <= height[r]):
                l += 1
                
        return maxArea