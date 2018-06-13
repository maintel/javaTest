
public class Main2{
    public static void main(String[] args) {
      System.out.println(B.TEST);
      A a1 = new A();
      A a2 = new B();
      a1.staticMethod();
      a2.staticMethod();

      A.staticMethod();
      B.staticMethod();
     
    }
}