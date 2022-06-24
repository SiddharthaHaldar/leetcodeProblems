/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = 0,right = 0;
        //if(root.left != null)
            left = 1 + dfs(root.left);
        //if(root.right != null)
            right = 1 + dfs(root.right);
        max = Math.max(max,left + right - 2);
        return Math.max(left,right);
    }
}