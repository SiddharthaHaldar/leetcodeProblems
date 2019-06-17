class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len=nums.length,x,y=len-1;
        if(len==1)
            return 0;
        int high=nums[0],idxh=0,h=0;
        int low=nums[len-1],idxl=len-1,l=0;
        for(x=0;x<=len-2;x++)
        {
            if(nums[x]>=high && nums[x+1]<nums[x])
            { high=nums[x];
              idxh=x;
            }
            if(nums[y]<=low && nums[y-1]>nums[y])
            {low=nums[y];
             idxl=y;
            }
            y-=1;
        }
        for(x=idxh+1;x<len;x++)
        {
            if(nums[idxh]<=nums[x])
            {  
                break;
            }
        }
        h=x-1;
        for(x=idxl-1;x>=0;x--)
        {
            if(nums[x]<=nums[idxl])
            { 
                break;}
        }
        l=x+1;
        int diff=0;
        if(h-l<0)
            diff=0;
        else
            diff=h-l+1;
        return diff;
    }
}