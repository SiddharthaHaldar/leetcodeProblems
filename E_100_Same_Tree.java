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
    public boolean helper(TreeNode p,TreeNode q)
    {
        boolean t=false;
        if(p==null && q==null)
            t=true;
        else if(p==null || q==null)
            t=false;
        else if(p.val==q.val)
            t=helper(p.left,q.left) && helper(p.right,q.right);
        return t;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
}