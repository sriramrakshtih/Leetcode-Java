/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
    
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode curr = dummyHead, p = l1, q = l2;
        
        while( p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            int sum = x + y + carry;
            carry = sum  / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if( p != null) p = p.next;
            if( q != null) q = q.next;
        }
        
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        
        return dummyHead.next;
        
        
    }
}