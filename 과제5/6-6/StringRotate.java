import java.util.Scanner;

public class StringRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String input = sc.nextLine(); // 한 줄 전체 입력

        int len = input.length();

        for (int i = 1; i < len; i++) {
            // 문자열을 왼쪽으로 한 글자 회전한 형태 출력
            String rotated = input.substring(i) + input.substring(0, i); // i부터 끝까지 + 0 ~ i-1까지
            System.out.println(rotated);
        }

        sc.close();
    }
}