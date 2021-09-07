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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return list;
        
        while(!st.isEmpty() || root != null){
            
            while(root != null) {
                list.add(root.val);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return list;
    }
}
