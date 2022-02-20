class Solution {
    public boolean wordPattern(String pattern, String s) {
        char C[] = pattern.toCharArray();
        HashMap<String,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        String str[] = s.split("\s");
        if(str.length != C.length)
            return false;
        for(int x = 0;x < str.length; x++){
            if(!map.containsKey(str[x])){
                if(!set.contains(C[x])){
                    set.add(C[x]);
                    map.put(str[x],C[x]);
                    }
                else
                    return false;
                }
            }
        StringBuilder sb = new StringBuilder();
        for(String st : str){
           sb.append(map.get(st));
        }
         return pattern.equals(sb.toString());
     }
}