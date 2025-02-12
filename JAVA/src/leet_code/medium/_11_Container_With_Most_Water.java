package leet_code.medium;

public class _11_Container_With_Most_Water {
	class Solution {
		public int maxArea(int[] height) {
			int answer = 0;

			int left = 0;
			int right = height.length-1;

			while (left <= right) {
				answer = Math.max(answer, (right- left) * Math.min(height[left], height[right]));

				if (height[left] < height[right]) {
					left++;
				} else {
					right--;
				}
			}

			return answer;
		}
	}
}
