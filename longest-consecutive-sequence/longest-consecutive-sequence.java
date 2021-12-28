class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxL = 0;
        for(int x = 0; x < nums.length ; x++)
            map.put(nums[x],0);
        for(int x = 0; x < nums.length ; x++){
           if(map.get(nums[x]) == 0) {
               map.put(nums[x],1);
               int next = nums[x] + 1;
               int l = 1;
               while(map.containsKey(next)){
                   //If the path has already been found,dont compute,just add to l
                   if(map.get(next) > 1){
                       l += map.get(next);
                       break;
                   }
                   map.put(next,1);
                   next += 1;
                   l++;
               }
               //Also store this length l against the element, this will be save time, through the logic in the while loop!
               map.put(nums[x],l);
               maxL = Math.max(maxL,l);
           }
        }
        return maxL;
    }
}