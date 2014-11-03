/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a sorted linked list, delete all nodes that have duplicate 
 * numbers, leaving only distinct numbers from the original list.
 * For example, 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II on LeetCode</a>
 */
public class RemoveDuplicatesSortedList2 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = new ListNode(0), first = prev;
        prev.next = head;
        boolean remove = false;
        while (head.next != null) {
            if (head.next.val == head.val) {
                remove = true;
                head.next = head.next.next;
            }
            else {
                if (remove) prev.next = head.next;
                else prev = head;
                head = head.next;
                remove = false;
            }
        }
        if (remove) prev.next = head.next;
        return first.next;
    }
}
