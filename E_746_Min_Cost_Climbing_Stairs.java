class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int l=cost.length;
        for(int x=l-3;x>=0;x--)
            cost[x]=Math.min(cost[x]+cost[x+1],cost[x]+cost[x+2]);
        return Math.min(cost[0],cost[1]);
    }
}