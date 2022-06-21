class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length(),l = s2.length();
        
        Map<Character,Integer> maps1 = new HashMap<>();
        Map<Character,Integer> maps2 = new HashMap<>();
        
        for(char c : s1.toCharArray()){
            if(!maps1.containsKey(c))
                maps1.put(c,0);
            maps1.put(c,maps1.get(c)+1);
        }
        
        System.out.println(maps1);
        int left = 0, right = 0;
        for(int x =0 ; x < l ; x++){
            char c = s2.charAt(right);
            if(!maps1.containsKey(c)){
                maps2.clear();
                right++;
                left = right;
            }
            else{
                right++;
                maps2.put(c,maps2.getOrDefault(c,0)+1);
                while(maps2.get(c) > maps1.get(c)){
                    char c2 = s2.charAt(left);
                    maps2.put(c2,maps2.get(c2)-1);
                    left++;
                }
                if(right - left == k)
                    return true;
            }
        }
        return false;
    }
}