package hsat;

import java.io.IOException;
import java.util.Scanner;

public class Lv2_지도_자동_구축 {
	public class Main {
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);

			int N = sc.nextInt();

			int tmp = (int) Math.pow(2, N) + 1;

			System.out.println(tmp * tmp);
		}
	}
}
