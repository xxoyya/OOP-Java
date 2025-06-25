import java.util.Scanner;

public class RandomArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[4][4]; // 4x4 배열 선언
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");

        // 랜덤 값으로 초기화 및 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int)(Math.random() * 256); // 0~255
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        // 임계값 입력 받기
        System.out.print("임계값 입력>>");
        int threshold = scanner.nextInt();

        // 임계값 비교해서 수정
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > threshold) {
                    arr[i][j] = 255;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        // 수정된 배열 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}