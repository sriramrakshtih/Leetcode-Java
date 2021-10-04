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
    
    public int sumOfLeftLeaves(TreeNode root) {
        return preorder(root, false);
    }
    
    private int preorder(TreeNode root, boolean isLeft) {
        int sum = 0;
        if(root.left == null && root.right == null){
            if(isLeft){
                return root.val;
            } else {
                return 0;
            }
        } else {
            if(root.left != null) {
                sum += preorder(root.left, true);
            }
            if(root.right != null) {
                sum += preorder(root.right, false);
            }
        }
        return sum;
    }
}