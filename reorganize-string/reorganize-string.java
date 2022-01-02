class Solution {
    class Pair{
        char c;int count;
        public Pair(char c,int count){
            this.c = c;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int x = 0;x < s.length() ; x++){
            char c = s.charAt(x);
            if(map.containsKey(c))
                map.put(c,map.get(c) + 1);
            else
                map.put(c,1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });
        for(Character c : map.keySet()){
            queue.add(new Pair(c,map.get(c)));
        }
        StringBuilder str = new StringBuilder();
        while(queue.size() > 0){
           Pair pair = queue.poll();
           int count = pair.count;
           char c = pair.c;
           while(count > 0 && queue.size() > 0){
               str.append(c);
               Pair newPair = queue.poll();
               str.append(newPair.c);
               if(newPair.count - 1 > 0)
                    queue.add(new Pair(newPair.c,newPair.count - 1));
               count -= 1;
           }
           if(count > 1 && queue.size() == 0)
               return "";
            else if(count == 1 && queue.size() == 0)
                str.append(c);
        }
        System.out.println(queue);
        return str.toString();
    }
}