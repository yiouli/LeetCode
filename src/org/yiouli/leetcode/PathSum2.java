/**
 * @author Yiou Li
 */
package org.yiouli.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * @see <a href="https://oj.leetcode.com/problems/path-sum-ii/">Path Sum II on LeetCode</a>
 */
public class PathSum2 {

	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private void discover(TreeNode node, int sum, int pathSum, LinkedList<Integer> path, List<List<Integer>> result) {
        if (node != null) {
            path.addLast(node.val);
            if (node.left == null && node.right ==null && node.val+pathSum ==sum) result.add(new ArrayList<Integer>(path));
            else {
                discover(node.left, sum, pathSum+node.val, path, result);
                discover(node.right, sum, pathSum+node.val, path, result);
            }
            path.removeLast();
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        discover(root, sum, 0, path, ret);
        return ret;
    }
}
