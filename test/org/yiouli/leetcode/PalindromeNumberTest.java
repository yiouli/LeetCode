package org.yiouli.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import org.yiouli.leetcode.easy.PalindromeNumber;

public class PalindromeNumberTest {

	@Test
	public void Test1() {
		PalindromeNumber obj = new PalindromeNumber();
		assertTrue(obj.isPalindrome(12321));
	}

}
