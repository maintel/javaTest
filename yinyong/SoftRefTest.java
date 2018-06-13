package yinyong;

public class SoftRefTest<T> {

    private T value;

    public SoftRefTest(T t) {
        this.value = t;
    }

    public T get() {
        return value;
    }
}
