/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head) return NULL;
        ListNode *root = head->next, *prev = head;
        while (root) {
            ListNode* nxt = root->next;
            root->next = prev;
            prev = root;
            root = nxt;
        }
        head->next = NULL;
        return prev;
    }
};