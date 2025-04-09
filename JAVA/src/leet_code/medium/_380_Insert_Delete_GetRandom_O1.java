package leet_code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class _380_Insert_Delete_GetRandom_O1 {


	// Array의 삭제 연산은 O(N)이지만
	// 마지막 인덱스를 삭제하는 것은 O(1)이라는 특징을 이용하여 arr의 삭제하려는 값을 마지막 Idx와 바꾼 후 삭제하는 것이 핵심인 문제

	class RandomizedSet {

		static HashMap<Integer, Integer> map;
		static ArrayList<Integer> arr;
		static Random random;

		public RandomizedSet() {
			map = new HashMap<>();
			arr = new ArrayList<>();
			random = new Random();
		}

		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}

			map.put(val, arr.size());
			arr.add(val);

			return true;
		}

		public boolean remove(int val) {
			if (!map.containsKey(val)) return false;

			int idx = map.get(val);
			int lastIdx = arr.size() - 1;

			if (idx != lastIdx) {
				int lastVal = arr.get(lastIdx);
				arr.set(idx, lastVal);
				map.put(lastVal, idx);
			}

			arr.remove(lastIdx);
			map.remove(val);

			return true;
		}

		public int getRandom() {
			return arr.get(random.nextInt(arr.size()));
		}
	}
}
