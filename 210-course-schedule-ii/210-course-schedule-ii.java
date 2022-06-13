class Solution {
    HashSet<Integer> inserted;
    int pos = -1;
    int[] output;
    HashSet<Integer> visited = new HashSet<Integer>();
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        inserted = new HashSet<Integer>(numCourses);
        output = new int[numCourses];
        int r = pre.length;
        boolean res = true;
        for(int x = 0; x < r; x++){
            int course = pre[x][0]; 
            if(!adj.containsKey(course)){
                List<Integer> l = new ArrayList<>();
                l.add(pre[x][1]);
                adj.put(course,l);
            }
            else{
                adj.get(course).add(pre[x][1]);
            }
            if(!adj.containsKey(course))
                adj.put(course,new ArrayList<>());
        }
        for(int x = 0;x < numCourses;x++){
            if(!inserted.contains(x)){
                res = res & dfs(x,adj);
                if(!res)
                    return new int[0];
            }
        }
        
        List<Integer> output2 = new ArrayList<Integer>();
        output2.toArray(new Integer[10]);
        return output;
    }
    public boolean dfs(Integer key,Map<Integer,List<Integer>> map){
        if(visited.contains(key))
            return false;
        visited.add(key);
        boolean res = true;
        List<Integer> l = map.getOrDefault(key,new ArrayList<>());
        for(Integer el : l){
           if(!inserted.contains(el)){
               res = res & dfs(el,map);
               if(!res)
                   break;
           }
        }
        //The inserted set helps in keeping track whether the node has already been porcessed. Using this infor, this node will not be visited in the future. this is similar to setting an empty arraylist against the node
        visited.remove(key);
        inserted.add(key);
        output[++pos] = key;
        return res;
    } 
}
