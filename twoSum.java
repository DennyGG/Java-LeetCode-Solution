package testLeet;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 */
public class twoSum {
	public static void main(String[] args) {
		twoSum tw = new twoSum();
		for(int i=0;i<tw.twoSum1(new int[]{2,7,11,15}, 9).length;i++) {
			System.out.println(tw.twoSum1(new int[]{2,7,11,15}, 9)[i]);
		}
		for(int i=0;i<tw.twoSum2(new int[]{2,7,11,15}, 9).length;i++) {
			System.out.println(tw.twoSum2(new int[]{2,7,11,15}, 9)[i]);
		}
	}

	public int[] twoSum1(int[] nums, int target) {
		int[] result = {};
		for(int i=0;i<nums.length;i++) {
			for(int j = i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					result = new int[] {i,j};
					return result;
				}
			}
		}
		return result ;
	}
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer>map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int other = target-nums[i];
			if(map.containsKey(other)) {
				return new int[] {map.get(other),i};
			}
			map.put(nums[i], i);
		}
		return new int[]{} ;
	}
}
