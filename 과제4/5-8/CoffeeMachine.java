import java.util.Scanner;

abstract class Box {
    protected int size; // 현재 박스에 들어 있는 재료의 양

    public Box(int size) { // 생성자
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
    public abstract void print(); // 박스에 들어 있는 양을 "*" 문자로 출력
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (size > 0) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(size);
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox cream = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);

        System.out.println("*****청춘 커피 자판기 입니다.*****");

        while (true) {
            coffee.print();
            cream.print();
            sugar.print();
            System.out.print("다방 커피: 1, 설탕 커피: 2, 블랙 커피: 3, 종료: 4 >>");

            int choice = scanner.nextInt();

            boolean canMake = true;

            switch (choice) {
                case 1: // 다방 커피: 커피 + 프림 + 설탕
                    if (coffee.isEmpty() || cream.isEmpty() || sugar.isEmpty()) {
                        canMake = false;
                    } else {
                        coffee.consume();
                        cream.consume();
                        sugar.consume();
                    }
                    break;
                case 2: // 설탕 커피: 커피 + 설탕
                    if (coffee.isEmpty() || sugar.isEmpty()) {
                        canMake = false;
                    } else {
                        coffee.consume();
                        sugar.consume();
                    }
                    break;
                case 3: // 블랙 커피: 커피만
                    if (coffee.isEmpty()) {
                        canMake = false;
                    } else {
                        coffee.consume();
                    }
                    break;
                case 4:
                    System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }

            if (!canMake) {
                System.out.println("원료가 부족합니다.");
            }
        }
    }
}