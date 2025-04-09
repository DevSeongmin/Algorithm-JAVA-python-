package leet_code.medium;

public class _134_Gas_Station {

	class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int totalGas = 0, totalCost = 0;
			for (int i = 0; i < gas.length; i++) {
				totalGas += gas[i];
				totalCost += cost[i];
			}

			// 가스의 총량보다 코스트가 높다면 한바퀴 순회가 불가능하다.
			if (totalGas < totalCost) {
				return -1;
			}

			int currentGas = 0;
			int start = 0;


			// 이후 핵심 그리디 풀이 법
			// 한 점에서 이동을 하며 현재 보유 가스가 음수가 되는 순간에는 그 시작점에서는 한바퀴 순회가 불가능 하다는 것
			// 그래서 다음 양수 시작점으로 다시 시작
			// 이렇게 start 가 답이 되는 것에 대해서는 가스의 총량이 비용의 총량보다 크거나 같기에 자명하다.
			// i 에서 시작해서 i + 4 에서 처음으로 음수가 되었다고 쳤을 때
			// i +1, +2, +3, 부터 i+4로 가는것은 무조건 가수 보유량이 음수가 된다 그렇기에 다음 start 지점을 i+1로 시작한다.

			for (int i = 0; i < gas.length; i++) {
				currentGas += gas[i] - cost[i];
				if (currentGas < 0) {
					currentGas = 0;
					start = i + 1;
				}
			}

			return start;
		}
	}
}
