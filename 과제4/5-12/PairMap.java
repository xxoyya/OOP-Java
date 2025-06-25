public abstract class PairMap {
    protected String keyArray[];
    protected String valueArray[];
    public abstract String get(String key);
    public abstract void put(String key, String value);
    public abstract String delete(String key);
    public abstract int length();
}