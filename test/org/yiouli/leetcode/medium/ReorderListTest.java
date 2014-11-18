package org.yiouli.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReorderListTest {

	@Test
	public void test1() {
		ReorderList obj = new ReorderList();
		ReorderList.ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		obj.reorderList(head);
		assertNotNull(head.next);
		assertEquals(2, head.next.val);
	}

}
