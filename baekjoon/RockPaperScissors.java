package baekjoon;

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		String[] str = {"가위", "바위", "보"};
		Scanner scanner = new Scanner(System.in);
		String userInput;

		System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
		while (true) {
			System.out.print("가위 바위 보! >> ");
			userInput = scanner.nextLine();

			if (userInput.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}

			int n = (int)(Math.random() * 3); // 컴퓨터의 선택
			String computerChoice = str[n];

			System.out.println("사용자 = " + userInput + ", 컴퓨터 = " + computerChoice);
			if (userInput.equals(computerChoice)) {
				System.out.println("비겼습니다.");
			} else if ((userInput.equals("가위") && computerChoice.equals("보"))||
			(userInput.equals("바위") && computerChoice.equals("가위"))||
			(userInput.equals("보") && computerChoice.equals("바위"))) {
				System.out.println("사용자가 이겼습니다!");
			} else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
		}
		scanner.close();
	}
}