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
        for(int key = 0; key <= numCourses-1 ; key++){
            res = res & dfs(key,map,visited);
            if(!res)
                return res;
            //Set the value of the key to a an empty list
            //This is because afetr each traversal if no cycles are detected we know that that course/node can be traveresed sefely without any cycles.
            //map.put(key,new ArrayList<>());
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
        map.put(key, new ArrayList<>());
        visited.remove(key);
        return res;
    } 
}