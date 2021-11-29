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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode dummy = new ListNode(-101);
        ListNode dummyPointer = dummy;
        while(curr != null) {
            if(!set.contains(curr.val)){
                dummyPointer.next = new ListNode(curr.val);
                set.add(curr.val);
                dummyPointer = dummyPointer.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}