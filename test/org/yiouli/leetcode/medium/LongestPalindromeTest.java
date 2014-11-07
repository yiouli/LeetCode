package org.yiouli.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromeTest {

	@Test
	public void test1() {
		LongestPalindrome obj = new LongestPalindrome();
		assertEquals("abababa",obj.longestPalindrome("abababac"));
	}

	@Test
	public void test2() {
		LongestPalindrome obj = new LongestPalindrome();
		assertEquals("ccc",obj.longestPalindrome("ccc"));
	}
}
