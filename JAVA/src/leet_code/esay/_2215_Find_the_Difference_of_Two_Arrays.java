package leet_code.esay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _2215_Find_the_Difference_of_Two_Arrays {
	class Solution {
		public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
			HashSet<Integer> set1 = new HashSet();
			HashSet<Integer> set2 = new HashSet();
			HashSet<Integer> addSet1 = new HashSet();
			HashSet<Integer> addSet2 = new HashSet();

			for (int num : nums1){
				set1.add(num);
			}
			for (int num : nums2){
				set2.add(num);
			}


			ArrayList<Integer> list1 = new ArrayList();
			for (int num : nums1){
				if (set2.contains(num)) continue;
				if (addSet1.contains(num)) continue;

				addSet1.add(num);
				list1.add(num);
			}

			ArrayList<Integer> list2 = new ArrayList();
			for (int num : nums2){
				if (set1.contains(num)) continue;
				if (addSet2.contains(num)) continue;

				addSet2.add(num);
				list2.add(num);
			}

			List<List<Integer>> answer = new ArrayList();
			answer.add(list1);
			answer.add(list2);

			return answer;
		}
	}
}
