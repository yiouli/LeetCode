package org.yiouli.leetcode.medium;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PreorderTraversalTest {

	@Test
	public void test1() {
		PreorderTraversal obj = new PreorderTraversal();
		PreorderTraversal.TreeNode root = obj.new TreeNode(1);
		root.left = obj.new TreeNode(2);
		assertEquals(Arrays.asList(1,2), obj.preorderTraversal(root));
	}

}
