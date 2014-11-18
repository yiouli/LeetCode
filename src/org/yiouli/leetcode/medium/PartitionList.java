/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @see <a href="https://oj.leetcode.com/problems/partition-list/">Partition List on LeetCode</a>
 */
public class PartitionList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode partition(ListNode head, int x) {
		ListNode bond = new ListNode(0);
		bond.next = head;
		ListNode less = bond, prev=bond;
		while (head != null) {
			ListNode current = head;
			head = head.next;
			if (current.val >= x) prev = current;
			else if (less.next == current) prev = less = current;
			else {
				prev.next = current.next;
				current.next = less.next;
				less.next = current;
				less = current;
			}
		}
		return bond.next;
	}
}
