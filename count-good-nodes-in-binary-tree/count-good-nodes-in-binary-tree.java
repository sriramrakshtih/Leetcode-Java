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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int max) {
        int temp = 0;
        if(root == null) return 0;
        
        if(root.val >= max){
            max = root.val;
            temp++;
        }
        int left = dfs(root.left, max);
        // if(root.val > max){
        //     max = root.val;
        //     count++;
        // }
        
        int right = dfs(root.right, max);
        
        return left + right + temp;
    }
}