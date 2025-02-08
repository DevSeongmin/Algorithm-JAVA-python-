package leet_code.esay;

import java.util.ArrayList;
import java.util.List;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {
	class Solution {
		public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

			int l = candies.length;
			int maxVal = 0;

			for (int candy : candies) {
				maxVal = Math.max(maxVal, candy);
			}

			ArrayList<Boolean> answer = new ArrayList();

			for (int i = 0; i < l; i++){
				answer.add(candies[i] + extraCandies >= maxVal);
			}

			return answer;
		}
	}
}
