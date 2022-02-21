class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] pre = prerequisites;
        int rows = prerequisites.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Boolean> visited = new HashMap<>();
        //return false;
        for(int x = 0; x < rows;x++){
            if(!map.containsKey(pre[x][0])){
                List<Integer> l = new ArrayList<>();
                l.add(pre[x][1]);
                map.put(pre[x][0],l);
            }
            else{
                List<Integer> l = map.get(pre[x][0]);
                l.add(pre[x][1]);
                map.put(pre[x][0],l);
            }
        }
        boolean res = true;
        for(Integer key : map.keySet()){
            res = res & dfs(key,map,visited);
            if(!res)
                return res;
            map.put(key,new ArrayList<>());
        }
        return res;
    }
    public boolean dfs(Integer key,Map<Integer,List<Integer>> map,Map<Integer,Boolean> visited){
        if(visited.containsKey(key))
            return false;
        visited.put(key,true);
        List<Integer> l = map.getOrDefault(key,new ArrayList<>());
        boolean res = true;
        for(Integer el : l){
           res = res & dfs(el,map,visited);
           if(!res)
               break;
        }
        //Optimization in line 41. Remove this node, as it has already been dealt with!!
        visited.remove(key);
        return res;
    } 
}