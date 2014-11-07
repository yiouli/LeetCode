/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
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
 * return [1,2,3].
 * 
 * @see <a href="https://oj.leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree Preorder Traversal on LeetCode</a>
 */
public class PreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> path = new Stack<TreeNode>();
        while (!path.empty() || root != null) {
        	if (root != null) {
        		path.push(root);
        		ret.add(root.val);
        		root = root.left;
        	}
        	else root = path.pop().right;
        }
        return ret;
    }
}
