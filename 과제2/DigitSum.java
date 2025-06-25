import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10]; // 일차원 배열 선언
        System.out.print("양의 정수 10개 입력>>");

        // 입력받아서 배열에 저장
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.print("자리수의 합이 9인 것은...");

        // 자리수 합 구해서 출력
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            int sum = 0;

            // 자리수의 합 구하기 → while 이용
            while (n > 0) {
                sum += n % 10;   // 마지막 자리 더하기
                n /= 10;         // 마지막 자리 제거
            }
            if (sum == 9) {
                System.out.print(numbers[i] + " ");
            }
        }

        scanner.close();
    }
}