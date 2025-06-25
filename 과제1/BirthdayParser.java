import java.util.Scanner;

public class BirthdayParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("생일 입력 하세요>>");

        int birth = scanner.nextInt();
        int year = birth / 10000; // 앞 4자리 → 연도
        int month = (birth % 10000) / 100; // 중간 2자리 → 월
        int day = birth % 100; // 마지막 2자리 → 일

        System.out.println(year + "년 " + month + "월 " + day + "일");
        scanner.close();
    }
}