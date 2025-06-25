import java.util.Scanner;

public class GraphicEditor {
    private Shape head = null;
    private Shape tail = null;

    public void insert(int type) {
        Shape newShape = null;
        switch (type) {
            case 1:
                newShape = new Line();
                break;
            case 2:
                newShape = new Rect();
                break;
            case 3:
                newShape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }

        if (head == null) {
            head = newShape;
            tail = newShape;
        } else {
            tail.setNext(newShape);
            tail = newShape;
        }
    }

    public void delete(int index) {
        if (head == null) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }

        if (index == 1) {
            head = head.getNext();
            if (head == null) tail = null; // 마지막 노드였던 경우 tail도 null 처리
            return;
        }

        Shape prev = head;
        Shape curr = head.getNext();
        int count = 2;

        while (curr != null && count < index) {
            prev = curr;
            curr = curr.getNext();
            count++;
        }

        if (curr == null) {
            System.out.println("삭제할 수 없습니다.");
        } else {
            prev.setNext(curr.getNext());
            if (curr == tail) {
                tail = prev;
            }
        }
    }

    public void show() {
        Shape curr = head;
        while (curr != null) {
            curr.draw();
            curr = curr.getNext();
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >>");
            int cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3) >>");
                    int type = sc.nextInt();
                    insert(type);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치 >>");
                    int index = sc.nextInt();
                    delete(index);
                    break;
                case 3:
                    show();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}