/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the 
 * nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 * 
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View on LeetCode</a>
 */
public class BinaryTreeRightSideView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;
        List<TreeNode> currentLvl = new ArrayList<TreeNode>();
        currentLvl.add(root);
        while (!currentLvl.isEmpty()) {
            ret.add(currentLvl.get(currentLvl.size()-1).val);
            List<TreeNode> prev = new ArrayList<TreeNode>(currentLvl);
            currentLvl.clear();
            for (TreeNode node : prev) {
                if (node.left != null) currentLvl.add(node.left);
                if (node.right != null) currentLvl.add(node.right);
            }
        }
        return ret;
    }

}
