/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 * 
 * @see <a href="https://oj.leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal on LeetCode</a>
 */
public class PostOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> path = new Stack<TreeNode>();
		while (!path.empty() || root != null) {
			if (root != null) {
				path.push(root);
				ret.addFirst(root.val);
				root = root.right;
			}
			else root = path.pop().left;
		}
		return ret;
	}
}
