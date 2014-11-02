/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.ArrayList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 * But the following is not:
 * 
 *   1
 *  / \
 * 2   2
 *  \   \
 *   3    3
 *   
 * @see <a href="https://oj.leetcode.com/problems/symmetric-tree/">Symmetric Tree on LeetCode</a>
 */
public class SymmetricTree {

	/**
	 * Definition for Binary Tree.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		return p.val == q.val
				&& isSymmetric(p.left, q.right)
				&& isSymmetric(p.right, q.left);
	}
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
	
	/**
	 * Based on BFS by level.
	 * @param root is the root node of the tree.
	 * @return whether the given tree is symmetric.
	 */
	public boolean isSymmetricIterative(TreeNode root) {
		ArrayList<TreeNode> currentLvl = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLvl = new ArrayList<TreeNode>();
		currentLvl.add(root);
		while (!currentLvl.isEmpty()) {
			for (TreeNode node : currentLvl) {
				if (node != null) {
					nextLvl.add(node.left);
					nextLvl.add(node.right);
				}
			}
			int n = nextLvl.size();
			for (int i = 0; i < n/2; i++) {
				TreeNode p = nextLvl.get(i);
				TreeNode q = nextLvl.get(n-i-1);
				if (p == null ^ q == null) return false;
				if (p != null && q != null & p.val != q.val) return false;
			}
			ArrayList<TreeNode> temp = currentLvl;
			currentLvl = nextLvl;
			nextLvl = temp;
			nextLvl.clear();
		}
		return true;
	}
}
