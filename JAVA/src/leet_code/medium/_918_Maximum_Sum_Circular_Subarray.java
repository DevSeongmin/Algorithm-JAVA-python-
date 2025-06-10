package leet_code.medium;

import java.util.Arrays;

public class _918_Maximum_Sum_Circular_Subarray {
	class Solution {

		// 1 카데인 알고리즘으로 일반 구간 최대 합
		// 2 왼쪽 누적합 + 오른쪽 누적합 가운데가 짤린 경우의 최댓값
		// answer = max(1, 2)
		public int maxSubarraySumCircularMySolution(int[] nums) {
			int l = nums.length;
			int answer = nums[0];
			int sum = nums[0];
			int idx = -1;

			for (int i = 1; i < l; i++) {
				int n = nums[i];

				if (sum < 0) {
					sum = 0;
					idx = i;
				}

				sum += n;
				answer = Math.max(sum, answer);
			}

			int[] leftPrefixSum = Arrays.copyOf(nums, l);
			int[] rightPrefixSum = Arrays.copyOf(nums, l);

			for (int i = 1; i < l; i++) {
				leftPrefixSum[i] += leftPrefixSum[i-1];
			}

			for (int i = l - 2; i >= 0; i--) {
				rightPrefixSum[i] += rightPrefixSum[i+1];
			}

			int[] rightPrefixIdx = new int[l];
			rightPrefixIdx[l-1] = l-1;

			for (int i = l-2; i >= 0; i--) {
				if (rightPrefixSum[i] > rightPrefixSum[rightPrefixIdx[i+1]]){
					rightPrefixIdx[i] = i;
				} else {
					rightPrefixIdx[i] = rightPrefixIdx[i + 1];
				}
			}

			answer = Math.max(answer, leftPrefixSum[l-1]);
			answer = Math.max(answer, rightPrefixSum[l-1]);

			for (int i = 0; i < l-2; i++) {
				answer = Math.max(answer, leftPrefixSum[i] + rightPrefixSum[rightPrefixIdx[i+1]]);
			}

			return answer;
		}
	}

	// 똑똑한 최적화 풀이
	// 1. 일반 카데인 최댓값
	// 2. 전체 누적합 - 카데인 최솟값      전체 - 최솟값 범위  [#, #, -, -, -, #, #]   -는 최솟값 범위
	// 									 자연 스럽게 앞2개 뒤 2개 선택 원형인 경우도 고려가 됨
	// 3. 만약 카데인 값이 음수라면 카데인값 아니라면 max(카데인값, total - 카데인 최솟값)
	public int maxSubarraySumCircular(int[] nums) {
		int total = 0;
		int maxRangeSum = nums[0];
		int curMaxVal = 0;
		int minRangeSum = nums[0];
		int curMinVal = 0;

		for (int num : nums) {
			total += num;
			curMaxVal = Math.max(curMaxVal + num, num);
			maxRangeSum = Math.max(maxRangeSum, curMaxVal);
			curMinVal = Math.min(curMinVal + num, num);
			minRangeSum = Math.min(minRangeSum, curMinVal);
		}

		if (maxRangeSum < 0) return maxRangeSum;

		return Math.max(maxRangeSum, total - minRangeSum);
	}
}
