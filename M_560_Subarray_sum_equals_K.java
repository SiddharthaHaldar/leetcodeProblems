import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k){
        int l=nums.length;
        HashMap < Integer, Integer > map = new HashMap < > ();
        int sum=0,c=0;
        map.put(0,1);
        for(int x=0;x<l;x++)
        {
            sum+=nums[x];
            if(map.containsKey(sum-k))
                c+=map.get(sum-k);
            if(!map.containsKey(sum))
                map.put(sum,1);
            else
                map.put(sum,map.get(sum)+1);
           }
        return c;
    }
}