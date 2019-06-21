class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        arr[0]=1;arr[1]=1;
        for(int x=2;x<=n;x++)
        {
            arr[x]=arr[x-1]+arr[x-2];
        }
        return arr[n];
    }
}