/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Sort a linked list using insertion sort.
 * 
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort List on LeetCode</a>
 */
public class InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode insertionSortList(ListNode head) {
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		ListNode prev = sentinel;
		while (prev.next != null) {
			ListNode sortedPrev = sentinel;
			while (sortedPrev.next.val < prev.next.val) sortedPrev = sortedPrev.next;
			if (sortedPrev != prev) {
				ListNode cur = prev.next;
				prev.next = cur.next;
				ListNode next = sortedPrev.next;
				sortedPrev.next = cur;
				cur.next = next;
			}
			else prev = prev.next;
		}
		return sentinel.next;
	}
}
