/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from 
 * the root node down to the nearest leaf node.
 * 
 * @see <a href="https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth on LeetCode</a>
 */
public class MinimumDepth {
	
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		int depth = 1, lvl = 1, nextLvl = 0;
		while (q.size() > 0) {
			TreeNode node = q.removeFirst();
			lvl--;
			if (node.left == null && node.right == null) break;
			if (node.left != null) {
				q.addLast(node.left);
				nextLvl++;
			}
			if (node.right != null) {
				q.addLast(node.right);
				nextLvl++;
			}
			if (lvl == 0) {
				lvl = nextLvl;
				depth++;
				nextLvl = 0;
			}
		}
		return depth;
	}
}
