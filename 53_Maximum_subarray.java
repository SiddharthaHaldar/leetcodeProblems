class Solution {
    public int maxSubArray(int a[]) 
    { 
        int max = a[0], curr=a[0]; 
        int size=a.length;
        for(int x=1;x<size;x++)
        {
            curr=curr+a[x];
            if(a[x]>curr)
                curr=a[x];
            if(max<curr)
                max=curr;
        }
        return max;  
    } 
} 