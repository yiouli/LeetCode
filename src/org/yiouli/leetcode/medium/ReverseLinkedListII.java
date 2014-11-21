/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * @see <a href="https://oj.leetcode.com/problems/reverse-linked-list-ii/">Reverse LinkedList II on LeetCode</a>
 */
public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(0), prev = sentinel;
        sentinel.next = head;
        int idx = 1;
        while (head.next != null && idx < n) {
            if (idx++ < m) {
                prev = prev.next;
                head = head.next;
            }
            else {
                //insert head.next between prev and prev.next
                ListNode tmp = prev.next;
                prev.next = head.next;
                head.next = head.next.next;
                prev.next.next = tmp;
            }
        }
        return sentinel.next;
    }
}
