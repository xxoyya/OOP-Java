public class VArray {
    private int[] array;
    private int size;

    public VArray(int num) {
        array = new int[num];
        size = 0;
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return size;
    }

    public void add(int n) {
        if (size >= array.length) resize();
        array[size++] = n;
    }

    public void insert(int index, int n) {
        if (index > size || index < 0) return;

        if (size >= array.length) resize();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = n;
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0) return;

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}