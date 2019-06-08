class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=nums.length;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int x=0;x<l;x++)
        {
            if(map.containsKey(target-nums[x]))
            {
                /*arr[0]=map.get(target-nums[x]);
                arr[1]=x;
                break;*/
                return new int[]{map.get(target-nums[x]),x};
            }
            else
            {
                map.put(nums[x],x);
            }
        }
        return new int[]{};
    }
}