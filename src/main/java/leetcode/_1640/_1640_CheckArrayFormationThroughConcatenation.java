package leetcode._1640;

import java.util.HashMap;
import java.util.Map;

public class _1640_CheckArrayFormationThroughConcatenation {

	public static void main(String[] args) {
		int[] arr = {91, 4, 64, 78};
		int[][] pieces = {{78}, {4, 64}, {91}};
		System.out.println(new Solution().canFormArray(arr, pieces));

		int[] arr1 = {49, 18, 16};
		int[][] pieces1 = {{16, 18, 49}};
		System.out.println(new Solution().canFormArray(arr1, pieces1));
	}

}

class Solution {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		Map<Integer, Integer> map = new HashMap<>();
		// initialize map
		for (int i = 0; i < pieces.length; i++) {
			final int ii = i;
			map.put(pieces[i][0], i);
		}
		//
		for (int i = 0; i < arr.length; ) {
			Integer pos = map.get(arr[i]);
			if(pos==null) return false;
			int[] piece = pieces[pos];
			if (!isMatched(arr, piece, i)) return false;
			i += piece.length;
		}
		return true;
	}

	boolean isMatched(int arr[], int piece[], int pos) {
		for (int i = 0; i < piece.length && i + pos < arr.length; i++) {
			if (arr[pos + i] != piece[i]) return false;
		}
		return true;
	}

}
