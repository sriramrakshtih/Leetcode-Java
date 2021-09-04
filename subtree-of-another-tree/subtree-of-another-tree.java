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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if(root == null || root.next == null) return root;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == subRoot.val && helper(curr, subRoot)){
                return true;
            }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            
        }
        return false;
    }
    
    private boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null | subRoot == null || root.val != subRoot.val) return false;
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}