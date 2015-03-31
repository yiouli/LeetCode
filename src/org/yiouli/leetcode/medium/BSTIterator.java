/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 * @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/">BST Iterator on LeetCode</a>
 */
public class BSTIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private Stack<TreeNode> path;

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	public BSTIterator(TreeNode root) {
		path = new Stack<TreeNode>();
		AddLessToPath(root);
	}

	private void AddLessToPath(TreeNode node) {
		while (node != null) {
			path.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !path.empty();
	}

	/** @return the next smallest number */
	public int next() {
		if (!hasNext()) throw new NoSuchElementException();
		TreeNode least = path.pop();
		AddLessToPath(least.right);
		return least.val;
	}
}


