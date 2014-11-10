/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * @see <a href="https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root To Leaf Numbers on LeetCode</a>
 */
public class SumRootToLeafNumbers {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public class Solution {

		private int sum(Stack<TreeNode> path) {
			int ret = 0;
			for (TreeNode node : path) {
				ret *= 10;
				ret += node.val;
			}
			return ret;
		}

		private int dfs(TreeNode node, Stack<TreeNode> path) {
			if (node == null) return 0;
			path.push(node);
			int ret;
			if (node.left == null && node.right == null) ret = sum(path);
			else ret = dfs(node.left, path) + dfs(node.right, path);
			path.pop();
			return ret;
		}

		public int sumNumbers(TreeNode root) {
			return dfs(root, new Stack<TreeNode>());
		}
	}
}
