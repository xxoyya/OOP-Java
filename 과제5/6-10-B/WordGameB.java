// 파일명: WordGameB.java
import java.util.Scanner;

public class WordGameB {

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

            long start = System.currentTimeMillis();
            System.out.print(">> ");
            String answer = sc.nextLine();
            long end = System.currentTimeMillis();

            double elapsed = (end - start) / 1000.0;

            if (answer.equals("그만")) break;

            if (elapsed > 10) {
                System.out.printf("실패!!! 10초 초과. %.3f초 경과\n", elapsed);
            } else if (answer.equals(word)) {
                System.out.printf("성공!!! %.3f초 경과\n", elapsed);
            } else {
                System.out.printf("실패!!! %s 입니다. %.3f초 경과\n", word, elapsed);
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