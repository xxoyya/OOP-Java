import java.util.Scanner;

public class PositiveAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        System.out.println("양의 정수를 입력하세요. -1은 입력 끝>>");

        while (true) {
            String input = scanner.next();

            if (input.equals("-1")) break;

            try {
                int n = Integer.parseInt(input);
                if (n > 0) {
                    sum += n;
                    count++;
                } else {
                    System.out.println(input + " 제외");
                }
            } catch (NumberFormatException e) {
                System.out.println(input + " 제외");
            }
        }

        if (count > 0) {
            System.out.println("평균은 " + (sum / count));
        } else {
            System.out.println("양수가 입력되지 않았습니다.");
        }
        scanner.close();
    }
}