// 파일명: WordGameA.java
import java.util.Scanner;

public class WordGameA {

    public static void main(String[] args) {
        String[] words = {
                "happy", "morning", "package", "together", "extract",
                "sunny", "lovely", "nation", "connect", "present"
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("10초 안에 단어를 맞히세요!!");

        for (String word : words) {
            String shuffled = shuffleWord(word);
            System.out.println(shuffled);
            System.out.print(">> ");
            String answer = sc.nextLine();

            if (answer.equals("그만")) break;

            if (answer.equals(word)) {
                System.out.println("성공!!!");
            } else {
                System.out.println("실패!!! " + word + " 입니다");
            }
        }

        sc.close();
    }

    public static String shuffleWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < 20; i++) {
            int a = (int) (Math.random() * chars.length);
            int b = (int) (Math.random() * chars.length);
            char tmp = chars[a];
            chars[a] = chars[b];
            chars[b] = tmp;
        }
        return new String(chars);
    }
}