/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @see <a href="https://oj.leetcode.com/problems/reorder-list/">Reorder List on LeetCode</a>
 */
public class ReorderList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast=head, slow=head;
        //find mid point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        ListNode next = slow.next;
        slow.next = null;
        while (next != null) {
            ListNode tmp = next;
            next = next.next; 
            tmp.next = slow;
            slow = tmp;
        }
        //0->1->2<-3<-4
        //0->1->2->3<-4<-5
        while (slow.next != null) {
            ListNode tmp = slow;
            slow = slow.next;
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }
    }
}
