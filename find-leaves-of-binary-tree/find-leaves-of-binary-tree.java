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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while(root.left != null || root.right != null){
            List<Integer> li = new ArrayList<>();
            dfs(root, li);
            res.add(li);
        }
        res.add(List.of(root.val));
        return res;
    }
    
    private TreeNode dfs(TreeNode root, List<Integer> li) {
        
        if(root == null) return null;
        if(root.left == null && root.right == null){
            li.add(root.val);
            return null;
        }
        
        root.left=dfs(root.left, li);
        root.right = dfs(root.right, li);
        
        
        return root;
    }
}