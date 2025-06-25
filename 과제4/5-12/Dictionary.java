public class Dictionary extends PairMap {
    private int capacity;
    private int count;

    public Dictionary(int capacity) {
        this.capacity = capacity;
        this.keyArray = new String[capacity];
        this.valueArray = new String[capacity];
        this.count = 0;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
        if (count < capacity) {
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i].equals(key)) {
                String deletedValue = valueArray[i];
                for (int j = i; j < count - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }
                keyArray[count - 1] = null;
                valueArray[count - 1] = null;
                count--;
                return deletedValue;
            }
        }
        return null;
    }

    @Override
    public int length() {
        return count;
    }
}