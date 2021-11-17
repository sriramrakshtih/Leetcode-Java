/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        last.right = first;
        first.left = last;
        return first;
    }
    
    private void dfs(Node root) {
        if(root != null){
            System.out.println("Root --> " + root.val);
        }
        if(root == null) return;
        dfs(root.left);
        if(last != null) {
            last.right = root;
            root.left = last;
            System.out.println("Root --> " + root.val);
            System.out.println("First -->" +first.val);
            System.out.println("Last -->" + last.val);
            
        } else {
            first = root;
        }
        
        last = root;
        System.out.println("First -->" +first.val);
        System.out.println("Last -->" + last.val);
        dfs(root.right);
        
    }
}