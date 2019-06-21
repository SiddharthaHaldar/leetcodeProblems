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
    public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q=new LinkedList<>();
            List<List<Integer>> ll=new ArrayList<>();
            if(root==null)
                return ll;
            List<Integer> l=new ArrayList<>();
            l.add(root.val);
            ll.add(l);
            q.add(root);
            while(q.isEmpty()!=true)
            {
                List<Integer> l2=new ArrayList<>();
                int qlen=q.size();
                for(int x=0;x<qlen;x++)
                {
                    TreeNode temp=q.poll();
                    if(temp.left!=null)
                    {
                        l2.add(temp.left.val);
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        l2.add(temp.right.val);
                        q.add(temp.right);
                    }
                }
                if(l2.size()!=0)
                    ll.add(l2);
            }
            return ll;
        }   
    }