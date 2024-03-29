class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int[] edge : edges){
            List<Integer> l = map.getOrDefault(edge[0],new ArrayList<>());
            List<Integer> l2 = map.getOrDefault(edge[1],new ArrayList<>());
            l.add(edge[1]);
            l2.add(edge[0]);
            map.put(edge[0],l);
            map.put(edge[1],l2);
        }
        int count = 0;
        for(int node : map.keySet()){
            if(!visited.contains(node) && map.get(node).size() > 0){
                count++;
                traverse(node,-1);
            }
        }
        //Since edges has only edges, there maybe a node, with no nodes connected to it,
        //and it will naturally not be present in edges. Thus (n-visited.size()) will give
        //us the count of those nodes that have no edges connected to them
        //This is useful for this case, n = 4 and edges = [[2,3],[1,2],[1,3]]
        return count + (n - visited.size());
    }
    public void traverse(int Node,int source){
        visited.add(Node);
        for(int node : map.get(Node)){
            if(node != source && !visited.contains(node)){
                traverse(node,Node);
            }
        }
        //map.put(Node,new ArrayList<>());
    }
}