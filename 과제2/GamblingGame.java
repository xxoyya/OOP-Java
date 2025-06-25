import java.util.Scanner;

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 갬블링 게임을 시작합니다 *****");

        while (true) {
            while (true) {
                System.out.print("엔터키 입력>>");
                scanner.nextLine(); // 엔터키 입력 대기

                // 0~2 랜덤 숫자 3개 생성
                int a = (int) (Math.random() * 3);
                int b = (int) (Math.random() * 3);
                int c = (int) (Math.random() * 3);

                System.out.println(a + " " + b + " " + c);

                if (a == b && b == c) {
                    System.out.println("성공! 대박났어요!");
                    break; // 내부 while문 탈출 → yes/no 묻기
                }
            }

            System.out.print("계속하시겠습니까?(yes/no)>>");
            String answer = scanner.nextLine();

            if (answer.equals("no")) {
                System.out.println("게임을 종료합니다.");
                break; // 게임 완전 종료
            }
            // "yes"면 계속 반복 (아무것도 안 해도 됨)
        }
        scanner.close();
    }
}