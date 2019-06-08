class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==0)
            return 0;
        if(l==1)
            return nums[0];
        int max=-1;
        int arr1[]=new int[l-1];
        int arr2[]=new int[l-1];
        for(int x=nums.length-1;x>=1;x--)
        {
            if(x==nums.length-1 || x==nums.length-2)
                {arr1[x-1]=nums[x];}
            else if(x==nums.length-3)
                arr1[x-1]=nums[x]+arr1[x+1];
            else
            {
                if(nums[x]+arr1[x+1]>nums[x]+arr1[x+2])
                    arr1[x-1]=nums[x]+arr1[x+1];
                else
                    arr1[x-1]=nums[x]+arr1[x+2];
            }
            if(arr1[x-1]>max)
                max=arr1[x-1];
                
        }
        for(int x=nums.length-2;x>=0;x--)
        {
            if(x==nums.length-2 || x==nums.length-3)
                {arr2[x]=nums[x];}
            else if(x==nums.length-4)
                arr2[x]=nums[x]+arr2[x+2];
            else
            {
                if(nums[x]+arr2[x+2]>nums[x]+arr2[x+3])
                    arr2[x]=nums[x]+arr2[x+2];
                else
                    arr2[x]=nums[x]+arr2[x+3];
            }
            if(arr2[x]>max)
                max=arr2[x];
        }
       
        return max;
    }
}