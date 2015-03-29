/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @see <a href="https://oj.leetcode.com/problems/valid-palindrome/">Valid Palindrome on LeetCode</a>
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
        int start = 0, end = s.length()-1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) start++;
            else if (!Character.isLetterOrDigit(s.charAt(end))) end--;
            else if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
