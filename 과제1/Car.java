import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 상태 입력>>");
        int status = scanner.nextInt();

        // Bitwise AND 연산 -> 상위 에어컨, 엔진 등 비트 무시, 하위 6비트만 남기기
        int temperature = status & 0b00111111;
        // 우측으로 각각 6, 7비트 밀기(LSR), 그 한 비트만 뽑기(Bitwise AND 연산)
        int airconditioner = (status >> 6) & 1;
        int engine = (status >> 7) & 1;

        String engineState = (engine == 1) ? "달리는 상태" : "정지 상태";
        String airconState = (airconditioner == 1) ? "켜진 상태" : "꺼진 상태";

        System.out.println("자동차는 " + engineState + "이고 에어컨이 " + airconState + "이고 온도는 " + temperature + "도이다.");

        scanner.close();
    }
}