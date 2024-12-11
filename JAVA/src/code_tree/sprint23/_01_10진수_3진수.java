package code_tree.sprint23;

import java.util.Scanner;

public class _01_10진수_3진수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String n = sc.next();
		int size = n.length();
		int digit = 0;

		for (int i = size - 1; i >= 0; i--){
			digit += (int) (n.charAt(i) - '0') * Math.pow(3, size - i - 1);
		}

		digit *= 22;

		StringBuilder sb = new StringBuilder();

		while (digit > 0){
			sb.append(digit % 3);

			digit /= 3;
		}

		System.out.println(sb.reverse().toString());
	}
}