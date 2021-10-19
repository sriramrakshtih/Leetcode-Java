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
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set1 = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root1 != null){
            while(root1 != null){
                st.push(root1);
                root1 = root1.left;
            }
            root1 = st.pop();
            set1.add(target - root1.val);
            root1 = root1.right;
        }
        
        while(!st.isEmpty() || root2 != null){
            while(root2 != null){
                st.push(root2);
                root2 = root2.left;
            }
            root2 = st.pop();
            if(set1.contains(root2.val)){
                return true;
            }
            root2 = root2.right;
        }
        
        return false;
    }
}