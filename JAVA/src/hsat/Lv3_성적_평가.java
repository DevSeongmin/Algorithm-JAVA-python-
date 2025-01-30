package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lv3_성적_평가 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			Score[][] scores = new Score[3][N];
			int[][] answers = new int[4][N];

			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					scores[i][j] = new Score(j, Integer.parseInt(st.nextToken()), -1);
				}
			}

			for (int i = 0; i < 3; i++) {
				PriorityQueue<Score> pq = new PriorityQueue(new Comparator<Score>(){
					@Override
					public int compare(Score s1, Score s2) {
						return Integer.compare(s2.score, s1.score);
					}
				});

				for (int j = 0; j < N; j++) {
					pq.add(scores[i][j]);
				}

				int lastScore = -1;
				int lastRank = -1;

				while (!pq.isEmpty()) {
					Score score = pq.poll();

					if (lastScore == score.score) {
						score.rank = lastRank;
						answers[i][score.idx] = score.rank;
						continue;
					}

					lastScore = score.score;
					score.rank = N - pq.size();
					lastRank = score.rank;
					answers[i][score.idx] = score.rank;
				}
			}


			PriorityQueue<Score> pq = new PriorityQueue(new Comparator<Score>(){
				@Override
				public int compare(Score s1, Score s2) {
					return Integer.compare(s2.score, s1.score);
				}
			});

			for (int i = 0; i < N; i++) {
				int value = 0;
				for (int j = 0; j < 3; j++) {
					value += scores[j][i].score;
				}
				pq.add(new Score(i, value, -1));
			}

			int lastScore = -1;
			int lastRank = -1;

			while (!pq.isEmpty()) {
				Score score = pq.poll();

				if (lastScore == score.score) {
					score.rank = lastRank;
					answers[3][score.idx] = score.rank;
					continue;
				}

				lastScore = score.score;
				score.rank = N - pq.size();
				lastRank = score.rank;
				answers[3][score.idx] = score.rank;
			}


			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(answers[i][j] + " ");
				}
				System.out.println();
			}
		}
		static class Score{
			int idx, score, rank;

			public Score(int idx, int score, int rank){
				this.idx = idx;
				this.score = score;
				this.rank = rank;
			}
		}
	}
}
