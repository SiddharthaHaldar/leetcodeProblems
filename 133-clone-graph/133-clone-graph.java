/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Node newNode = new Node();
        if(map.get(node.val) == null){
            newNode.val = node.val;
            map.put(node.val,newNode);
            for(Node neighbor : node.neighbors){
                Node newNeighbor = cloneGraph(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        else
            return map.get(node.val);
        return newNode;
    }
}