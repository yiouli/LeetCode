/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue", return "blue is sky the".
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 * @see <a href="https://oj.leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in String on LeetCode</a>
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for (int i = words.length; i > 0; i--) {
            if (words[i-1].length() == 0) continue;
            if (first) first = false;
            else buf.append(' '); 
            buf.append(words[i-1]);
        }
        return buf.toString();
    }
}
