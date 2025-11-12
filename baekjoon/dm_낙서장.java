package baekjoon;

import java.util.Scanner;

public class dm_낙서장 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("가위(1), 바위(2), 보(3), 끝내기(4)>>");
            int user = scanner.nextInt();
            int computer = (int) (Math.random() * 3) + 1;

            String computerStr = "";
            if (computer == 1) computerStr = "가위";
            else if (computer == 2) computerStr = "바위";
            else if (computer == 3) computerStr = "보자기";

            if (user == 1) {
                System.out.println("사용자 가위" + " : "  +"컴퓨터 "+ computerStr);
                if (computer == 1) {
                    System.out.println("무승부");
                }else if (computer == 2) {
                    System.out.println("사용자 패배");
                }else if (computer == 3) {
                    System.out.println("사용자 승리");
                }
            }
            else if (user == 2) {
                System.out.println("사용자 바위" + " : " + "컴퓨터 " + computerStr);
                if (computer == 1) {
                    System.out.println("사용자 승리");
                }else if (computer == 2) {
                    System.out.println("무승부");
                }else if (computer == 3) {
                    System.out.println("사용자 패배");
                }
            }
            else if (user == 3) {
                System.out.println("사용자 보자기" + " : " + "컴퓨터 " + computerStr);
                if (computer == 1) {
                    System.out.println("사용자 패배");
                }else if (computer == 2) {
                    System.out.println("사용자 승리");
                }else if (computer == 3) {
                    System.out.println("무승부");
                }
            }
            if (user == 4) {
                System.out.println("종료합니다");
                break;
            }
        }
    }

}
