class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        Max = 0 
        Min = float(inf)
        for price in prices:
            if price < Min:
                Min = price
            else:
                diff = price - Min
                Max = max(diff,Max)
            
        return Max