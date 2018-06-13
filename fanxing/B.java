package fanxing;

public class B extends A<String> {
    @Override
    public String getValue() {
        System.out.println("B::getValue");
        return super.getValue();
    }

    @Override
    public void setValue(String value) {
        System.out.println("B::setValue");
        super.setValue(value);
    }

    @Override
    public int getAnInt() {
        System.out.println("B::getAnInt");
        return super.getAnInt();
    }

    @Override
    public void setAnInt(int anInt) {
        System.out.println("B::setAnInt");
        super.setAnInt(anInt + 100);
    }
}
