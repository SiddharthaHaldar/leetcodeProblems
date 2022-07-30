class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        Max = float(-inf)
        Min = float(inf)
        for price in prices:
            Min = min(price,Min)
            diff = price - Min
            Max = max(diff,Max)
            
        return Max