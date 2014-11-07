/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *  /  \
 * 15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * 
 * @see <a href="https://oj.leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Traversal on LeetCode</a>
 */
public class LevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) return ret;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		int n;
		while ((n = q.size())!=0) {
			ArrayList<Integer> lvl = new ArrayList<Integer>(n);
			for (int i=0;i<n;i++) {
				TreeNode node = q.removeFirst();
				lvl.add(node.val);
				if (node.left != null) q.addLast(node.left);
				if (node.right != null) q.addLast(node.right);
			}
			ret.add(lvl);
		}
		return ret;
	}
}
