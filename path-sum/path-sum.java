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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    } 
    
    private boolean dfs(TreeNode root, int target, int currSum) {
        currSum += root.val;
        if(root.left == null && root.right == null && currSum == target) {
            return true;
        }
        
        if(root.left != null) {
            if(dfs(root.left, target, currSum)){
                return true;
            }
        }
        
        if(root.right != null) {
            if(dfs(root.right, target, currSum)){
                return true;
            }
        }
        return false;
    }
}