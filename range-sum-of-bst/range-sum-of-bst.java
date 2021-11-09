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
    int sum; int l, h;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        l =low;
        h = high;
        dfs(root);
        return sum;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) return;
        if(root.val >= l && root.val <= h){
            System.out.println(root.val);
            sum += root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
}