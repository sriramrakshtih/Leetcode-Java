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
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Stack<TreeNode> st = new Stack<>();
//         ArrayList<Integer> res = new ArrayList<>();
        
//         while(root != null || !st.isEmpty()) {
//             while(root!=null) {
//                 st.push(root);
//                 root = root.left;
//             }
            
//             root = st.pop();
//             res.add(root.val);
//             root= root.right;
//         }
//         return res;
//     }
// }


class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        
        res= new ArrayList<>();
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}