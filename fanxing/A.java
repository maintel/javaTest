package fanxing;

public class A<T> {
    private T value;

    private int anInt;
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }
}
