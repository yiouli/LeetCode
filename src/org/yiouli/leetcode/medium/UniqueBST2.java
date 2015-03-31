/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *   
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">Unique BST II on LeetCode</a>
 */
public class UniqueBST2 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
    private TreeNode clone(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = clone(root.left);
        newRoot.right = clone(root.right);
        return newRoot;
    }
    
    //assumption parentVal can be found by always going right from root, and newVal > parentVal
    private void insertToRight(TreeNode root, int parentVal, int newVal) {
        TreeNode parent = root;
        while (parent.val != parentVal) parent = parent.right;
        TreeNode node = new TreeNode(newVal);
        node.left = parent.right;
        parent.right = node;
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (n == 0) trees.add(null);
        else if (n == 1) trees.add(new TreeNode(1));
        else if (n != 0) {
            List<TreeNode> subs = generateTrees(n-1);
            for (TreeNode root : subs) {
                TreeNode parent = root;
                while (parent != null) {
                    TreeNode newTree = clone(root);
                    trees.add(newTree);
                    insertToRight(newTree, parent.val, n);
                    parent = parent.right;
                }
                TreeNode newRoot = new TreeNode(n);
                TreeNode newTree = clone(root);
                newRoot.left = newTree;
                trees.add(newRoot);
            }
        }
        return trees;
    }

}
