import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentNumbers = new int[10];
        int[] scores = new int[10];

        System.out.println("10명 학생의 학번과 점수 입력");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ">>");
            studentNumbers[i] = scanner.nextInt();
            scores[i] = scanner.nextInt();
        }

        while (true) {
            int menu = 0;
            // 메뉴 선택 잘못 입력 시 재입력
            while (true) {
                System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
                try {
                    menu = scanner.nextInt();
                    break; // 정상 입력 시 루프 탈출
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                    scanner.nextLine(); // 잘못된 입력 버퍼 비우기
                }
            }

            if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (menu == 1) { // 학번 검색
                int id;
                while (true) {
                    System.out.print("학번>>");
                    if (scanner.hasNextInt()) {
                        id = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next(); // 잘못된 입력 비우기
                    }
                }
                boolean found = false;
                for (int i = 0; i < 10; i++) {
                    if (studentNumbers[i] == id) {
                        System.out.println(scores[i] + "점");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println(id + "의 학생은 없습니다.");

            } else if (menu == 2) { // 점수 검색
                int score;
                while (true) {
                    System.out.print("점수>>");
                    if (scanner.hasNextInt()) {
                        score = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.next(); // 잘못된 입력 비우기
                    }
                }

                boolean found = false;
                String result = ""; // 찾은 학생 번호를 저장할 문자열

                for (int i = 0; i < 10; i++) {
                    if (scores[i] == score) {
                        result += (studentNumbers[i] + " ");
                        found = true;
                    }
                }

                if (found) {
                    System.out.println("점수가 " + score + "인 학생은 " + result.trim() + "입니다");
                } else {
                    System.out.println("점수가 " + score + "인 학생은 없습니다.");
                }
            } else {
                System.out.println("1, 2, 3 중에서 선택하세요.");
            }
        }
        scanner.close();
    }
}
