package Programmers;

public class Lv2_이모티콘_할인행사 {

	class Solution {

		static int[][] users;
		static int[] emoticons;
		static int emotionLength, emotionPlusAnswer, emotionRevenueAnswer;

		public int[] solution(int[][] users, int[] emoticons) {
			this.emotionLength = emoticons.length;
			this.users = users;
			this.emoticons = emoticons;

			getDiscountRepetitionCombination(0, emotionLength, new int[emotionLength]);

			return new int[] {emotionPlusAnswer, emotionRevenueAnswer};
		}

		static void getDiscountRepetitionCombination(int depth, int l, int[] emoticonDiscountRateArr) {
			if (depth >= l) {

				int[] tmp = getEmotionPlusAndEmotionRevenue(emoticonDiscountRateArr);

				int emotionPlus = tmp[0];
				int emotionRevenue = tmp[1];

				if (emotionPlus > emotionPlusAnswer) {
					emotionPlusAnswer = emotionPlus;
					emotionRevenueAnswer = emotionRevenue;
				} else if (emotionPlus == emotionPlusAnswer && emotionRevenue > emotionRevenueAnswer) {
					emotionRevenueAnswer = emotionRevenue;
				}

				return;
			}

			for (int i = 10; i <= 40; i+=10) {
				emoticonDiscountRateArr[depth] = i;
				getDiscountRepetitionCombination(depth + 1, l, emoticonDiscountRateArr);
			}
		}

		static int[] getEmotionPlusAndEmotionRevenue(int[] emoticonDiscountRateArr) {

			int emotionPlus = 0;
			int emotionRevenue = 0;

			for (int[] user : users) {
				int userPurchaseDiscount = user[0];
				int userMaximumPrice = user[1];

				int userPurchasePrice = 0;

				for (int i = 0; i < emotionLength; i++) {
					int emotionPrice = emoticons[i];
					int emotionDiscountRate =  emoticonDiscountRateArr[i];

					if (userPurchaseDiscount <= emotionDiscountRate) {
						userPurchasePrice += getDiscountPrice(emotionPrice, emotionDiscountRate);
					}
				}

				if (userPurchasePrice >= userMaximumPrice) {
					emotionPlus++;
				} else {
					emotionRevenue += userPurchasePrice;
				}
			}

			return new int[] {emotionPlus, emotionRevenue};
		}

		static int getDiscountPrice(int price, int discountRate) {
			return price *  (100 - discountRate) / 100;
		}
	}
}
