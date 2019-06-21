/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> q=new LinkedList<>();
            List<List<Integer>> ll=new ArrayList<>();
            if(root==null)
                return ll;
            List<Integer> l=new ArrayList<>();
            l.add(root.val);
            ll.add(l);
            q.add(root);
            int c=1;
            while(q.isEmpty()!=true)
            {
                List<Integer> l2=new ArrayList<>();
                int qlen=q.size();
                for(int x=0;x<qlen;x++)
                {
                    TreeNode temp=q.poll();
                    if(temp.left!=null)
                    {
                        if(c==1)
                            l2.add(0,temp.left.val);
                        else
                            l2.add(temp.left.val);
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        if(c==1)
                            l2.add(0,temp.right.val);
                        else
                            l2.add(temp.right.val);
                        q.add(temp.right);
                    }
                }
                if(l2.size()!=0)
                    ll.add(l2);
                c*=-1;
            }
            return ll;
        }   
    }