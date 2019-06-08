class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int max=-1;
        for(int x=nums.length-1;x>=0;x--)
        {
            if(x==nums.length-1 || x==nums.length-2)
                {}
            else if(x==nums.length-3)
                nums[x]=nums[x]+nums[x+2];
            else
            {
                if(nums[x]+nums[x+2]>nums[x]+nums[x+3])
                    nums[x]=nums[x]+nums[x+2];
                else
                    nums[x]=nums[x]+nums[x+3];
            }
            if(nums[x]>max)
                max=nums[x];
                
        }
        /*int max=-1;
        for(int x=0;x<nums.length;x++)
        {
            if(nums[x]>max)
                max=nums[x];
        }*/
        return max;
    }
}