/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a binary tree
 * Populate each next pointer to point to its next right node. If there is no next right node, 
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \  / \
 *   4->5->6->7 -> NULL
 *   
 * @see <a href="https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node on LeetCode</a>
 */
public class NextPointerInBinaryTree {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root.left != null) {
            TreeLinkNode lvl = root;
            while (lvl != null) {
                lvl.left.next = lvl.right;
                if (lvl.next != null) lvl.right.next = lvl.next.left;
                lvl = lvl.next;
            }
            root = root.left;
        }
    }
}
