package org.yiouli.leetcode.medium;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.yiouli.leetcode.medium.ThreeSum;

public class ThreeSumTest {

	@Test
	public void test1() {
		int[] num = {-1,0,1,2,-1,-4};
		ThreeSum obj = new ThreeSum();
		List<List<Integer>> results = obj.threeSum(num);
		assertEquals(2, results.size());
		assertArrayEquals(new Integer[]{-1,-1,2},results.get(0).toArray());
		assertArrayEquals(new Integer[]{-1,0,1},results.get(1).toArray());
	}

}
