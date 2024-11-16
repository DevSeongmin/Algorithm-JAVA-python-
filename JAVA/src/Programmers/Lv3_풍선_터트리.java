package Programmers;

public class Lv3_풍선_터트리 {
	public int solution(int[] a) {
		int answer = 2;
		int L = a.length;

		if (L < 3) {
			return L;
		}

		int[] leftMinArr = new int[L];
		leftMinArr[0] = a[0];
		int[] rightMinArr = new int[L];
		rightMinArr[L-1] = a[L-1];

		for (int i = 1; i < L; i++) {
			leftMinArr[i] = Math.min(leftMinArr[i-1], a[i]);
		}


		for (int i = L-2; i >= 0; i--) {
			rightMinArr[i] = Math.min(rightMinArr[i+1], a[i]);
		}


		for (int i = 1; i < L - 1; i++) {

			int leftMin = leftMinArr[i-1];
			int rightMin = rightMinArr[i+1];

			if (a[i] > leftMin && a[i] > rightMin) {continue;}

			answer++;

		}
		return answer;
	}
}