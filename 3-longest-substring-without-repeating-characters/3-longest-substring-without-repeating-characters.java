class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0,len = 0, left =0;
        Map<Character, Integer> map = new HashMap<>(); 
        for(int right = 0; right< n ; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
               //Check if there is already an optimal y - if y > map.get(c) a good y is already there 
               if(left <= map.get(c)){//condition necessary for case like : abba
                    left = map.get(c) + 1;
               }
            }
            //System.out.println(y+"\t"+x);
            len = Math.max(right - left + 1,len);
            map.put(c,right);
        }
        return len;
    }
}
//This is an optimised sliding windowa approach which takes O(n) time. or the non-optim one we maintaina set wheeer we keep adding new characters. if we come across an already existing character, we keep moving the lft pointer and simlutaneously removing elements from the set, until that character is no longer there in the set. this causes at most 2 traversals hence o(2n) which is O(n), but there are still two passes involved.