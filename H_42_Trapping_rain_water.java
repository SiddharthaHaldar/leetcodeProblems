class Solution {
    public int trap(int[] height) {
        int l=height.length,total=0;
        if(l==0)
            return total;
        int left[]=new int[l];
        int right[]=new int[l];
        left[0]=height[0];
        right[l-1]=height[l-1];
        for(int x=1;x<l;x++)
        {
            if(height[x]>=left[x-1])
                left[x]=height[x];
            else
                left[x]=left[x-1];
        }
        for(int x=l-2;x>=0;x--)
        {
            if(height[x]>=right[x+1])
                right[x]=height[x];
            else
                right[x]=right[x+1];
            total+=Math.min(right[x],left[x])-height[x];
        }
        return total;
    }
}