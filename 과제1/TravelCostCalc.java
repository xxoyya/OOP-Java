import java.util.Scanner;

public class TravelCostCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("여행지>>");
        String destination = scanner.nextLine();

        System.out.print("인원수>>");
        int people = scanner.nextInt();

        System.out.print("숙박일>>");
        int nights = scanner.nextInt();

        System.out.print("1인당 항공료>>");
        int airplanePrice = scanner.nextInt();

        System.out.print("1방 숙박비>>");
        int roomPrice = scanner.nextInt();

        int rooms;
        int totalCost;

        if (people % 2 == 0) {
            rooms = people / 2;
        }
        else {
            rooms = (people + 1) / 2;
        }

        totalCost = (airplanePrice * people) + (roomPrice * rooms * nights);

        System.out.println(
                people + "명의 " + destination + " " + nights + "박 " + (nights + 1) + "일 여행에는 방이 "
                + rooms + "개 필요하며 경비는 " + totalCost + "원입니다."
        );

        scanner.close();
    }
}