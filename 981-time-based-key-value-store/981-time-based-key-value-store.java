class TimeMap {
    Map<String,List<Integer>> mapT;
    Map<String,List<String>> mapV;
    public TimeMap() {
       this.mapT = new HashMap<>(); 
       this.mapV = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.mapT.containsKey(key)){
            List<Integer> lT = new ArrayList<>();
            //lT.add(-1);
            lT.add(timestamp);
            List<String> lV = new ArrayList<>();
            //lV.add("");
            lV.add(value);
            this.mapT.put(key,lT);
            this.mapV.put(key,lV);
        }
        else{
            List<Integer> lT = this.mapT.get(key);
            List<String> lV = this.mapV.get(key);
            lT.add(timestamp);
            lV.add(value);
            this.mapT.put(key,lT);
            this.mapV.put(key,lV);
        }
    }
    
    public String get(String key, int timestamp) {
       List<Integer> lT = this.mapT.get(key); 
        List<String> lV = this.mapV.get(key);
        //System.out.println(lT);
        //System.out.println(lV);
       if(lT == null || timestamp < lT.get(0))
           return "";
       int L = lT.size();
       int l = 0, r = L-1;
        int mid = 0;
       while(l <= r){
           mid = (l+r)/2;
           int val = lT.get(mid);
           if(val == timestamp)
               break;
           else if(val < timestamp){
               if(mid == (L-1))
                   break;
               else if(val < lT.get(mid+1))
                   if(timestamp < lT.get(mid + 1))
                        break;
                   else if(timestamp == lT.get(mid + 1)){
                       mid = mid + 1;
                       break;
                   }
                   else if(timestamp > lT.get(mid + 1))
                       l = mid + 1;
           }
           else{
               r = mid - 1;
           }
       }
       return this.mapV.get(key).get(mid);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */