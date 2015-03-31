/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate BST on LeetCode</a>
 */
public class ValidateBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) return true;
        return (root.val > low && root.val < high) 
            && isValidBST(root.left, low, root.val) 
            && isValidBST(root.right, root.val, high);
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
