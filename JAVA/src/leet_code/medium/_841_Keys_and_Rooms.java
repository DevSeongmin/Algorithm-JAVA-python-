package leet_code.medium;

import java.util.List;

public class _841_Keys_and_Rooms {
	class Solution {
		static boolean[] visited;
		static List<List<Integer>> rooms;
		public boolean canVisitAllRooms(List<List<Integer>> rooms) {
			this.rooms = rooms;
			visited = new boolean[rooms.size()];
			dfs(0);
			for (boolean tf : visited) {
				if (!tf) return false;
			}

			return true;
		} static void dfs(int roomNumber) {
			visited[roomNumber] = true;

			for (int nRoomNumber : rooms.get(roomNumber)) {
				if (visited[nRoomNumber]) continue;
				dfs(nRoomNumber);
			}
		}
	}
}
