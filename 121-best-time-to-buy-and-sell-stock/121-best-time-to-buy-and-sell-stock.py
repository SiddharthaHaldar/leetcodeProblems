class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        Max = 0 
        Min = float(inf)
        for x in range(0,len(prices)):
            price = prices[x]
            if price < Min:
                Min = price
            elif price - Min > Max:
                Max = price - Min
            
        return Max