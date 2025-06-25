import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연산 입력>>");
        double num1 = scanner.nextDouble();
        String op = scanner.next();
        double num2 = scanner.nextDouble();

        if(op.equals("나누기") && num2 ==0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }

        double result = switch (op) {
            case "더하기" -> num1 + num2;
            case "빼기" -> num1 - num2;
            case "곱하기" -> num1 * num2;
            case "나누기" -> num1 / num2;
            default -> {
                System.out.println("사칙연산이 아닙니다.");
                yield 0.0;
            }
        };

        if (op.equals("더하기") || op.equals("빼기") || op.equals("곱하기") || op.equals("나누기")) {
            System.out.println(num1 + " " + op + " " + num2 + "의 계산 결과는 " + result);
        }

        scanner.close();
    }
}