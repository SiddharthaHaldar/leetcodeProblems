class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        int e = edges.length;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            int source = edge[0];
            int dest = edge[1];
            Set<Integer> l = map.getOrDefault(source,new HashSet<>());
            Set<Integer> l2 = map.getOrDefault(dest,new HashSet<>());
            l.add(dest);
            l2.add(source);
            map.put(source,l);
            map.put(dest,l2);
        }
        //System.out.println(map);
        if(n == 1 && map.size() == 0)
            return true;
        for(int node : map.keySet()){
          boolean res = traverse(map,node,-1);
          if(!res)
              return res;
          //The next if check is crucial. If we start from one node and we are able to reach all nodes from there without any cycle that means we have successfully traversed the whole graph as a tree. If we did not have this check then we would unnecessarily iterate over the reast of the nodes and this would return a FLASE as these nodes have already been added to the visited set in the first pass!
          if(visited.size() == n) 
              return true;
        }
        return false;
    }
    public boolean traverse(Map<Integer,Set<Integer>> map,int node,int source){
        boolean res = true;
        if(visited.contains(node))
            return false;
        visited.add(node);
        for(int next : map.get(node)){
            if(next != source)
                res &= traverse(map,next,node);
            if(!res) 
                break;
        }
        return res;
    }
}