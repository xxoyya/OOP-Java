import java.util.Scanner;

public class MonthDiary {
    private int year, month;
    private DayDiary[] days;
    private Scanner scanner;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.days = new DayDiary[30];
        for (int i = 0; i < 30; i++) {
            days[i] = new DayDiary();
        }
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("***** %d년 %d월 다이어리 *****\n", year, month);
        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3>>");
            int menu = scanner.nextInt();
            if (menu == 1) {
                write();
            } else if (menu == 2) {
                show();
            } else if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int date = scanner.nextInt();
        String text = scanner.next();
        if (date < 1 || date > 30 || text.length() > 4) {
            System.out.println("입력이 잘못되었습니다.");
            return;
        }
        days[date - 1].setText(text);
    }

    private void show() {
        for (int week = 0; week < 5; week++) {
            for (int i = 0; i < 7; i++) {
                int index = week * 7 + i;
                if (index >= 30) break;
                System.out.print(days[index].getText() + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10);
        monthDiary.run();
    }
}