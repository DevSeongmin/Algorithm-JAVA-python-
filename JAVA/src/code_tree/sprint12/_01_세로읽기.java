package code_tree.sprint12;

import java.util.Scanner;

public class _01_세로읽기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strings = {sc.next(), sc.next(), sc.next(), sc.next()};

		StringBuilder answer = new StringBuilder();


		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 4; j++){
				try{
					answer.append(strings[j].charAt(i));
				} catch (Exception  e){

				}
			}
		}

		System.out.println(answer.toString());
	}
}
