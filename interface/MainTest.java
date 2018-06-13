public class MainTest{
  public static void main(String[] args) {
      // Palte<A> palte = new Palte<B>(new B());
      Palte<? extends A> palte2 = new Palte<B>(new B());
      palte2.get().printLn();
      Palte<? super B> palte3 = new Palte<A>(new A());
      ((A)(palte3.get())).printLn();
  }
}