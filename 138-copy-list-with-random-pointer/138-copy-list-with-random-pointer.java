/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
       Node node = head;
       Node copy = null;
       Node copyHead = copy;
       Node prev = null;
       while(node != null){
          if(!map.containsKey(node)){
              Node n = new Node(node.val); 
              map.put(node,n);
          }
          copy = map.get(node);
          if(prev != null){
              prev.next = copy;
          }
           else{
               copyHead = copy;
           }
           prev = copy;
           if(node.random != null){
                  if(!map.containsKey(node.random))
                   map.put(node.random,new Node(node.random.val));
             copy.random = map.get(node.random);
           }
           node = node.next;
       }
        node = copyHead;
        /*while(node != null){
            System.out.print(node.val+"\t");
            if(node.random != null){
                System.out.print(node.random.val);
            }
            System.out.println();
            node = node.next;
        }*/
        return copyHead;
    }
}