package swea;

import java.util.Scanner;

public class Swea1936_1대1_가위바위보 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] result = {
                {"" ,"B" , "A"},
                {"A" ,"" ,"B"},
                {"B" ,"A" ,"" }
        };


        int player1 = input.nextInt();
        int player2 = input.nextInt();


        System.out.println(result[player1-1][player2-1]);



    }
}
