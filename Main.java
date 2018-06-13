
public class Main{
    public static void main(String[] args) {

      Palte<? extends A> palte2 = new Palte<B>(new B());
      palte2.get().printLn();

      Palte<? super A> palte3 = new Palte<A>(new C());
      ((A)(palte3.get())).printLn(); // 这里可以向上转型成为父类
      ((B)(palte3.get())).print(); // 这里可以向上转型成为父类
      palte3.set(new C()); //但是 set 的时候只能 set A 的子类 因为只能向上转向不能向下转型
      palte3.set(new B());


      A a1 = new A();
      System.out.println("==========");
      A a2 = new B();
      System.out.println(a2.toString());      
      B b = new B();
      System.out.println(b.toString());  
      C c = new C();   
      D d = new D(); 

      a1.show(b); // B 向上转型 执行 A.show(A)
      System.out.println("a1.show(b)"); 
      
      a1.show(c); //c ==> b ==> a 执行结果为 A.show(A)
      System.out.println("a1.show(c); ");
      
      a1.show(d); //执行 A.show(D)
      System.out.println("a1.show(d); ");
      
      a2.show(b);// 这个最为关键 A a2 = new B(); 
      //栈中的引用变量是A，堆中的实例变量是B。
      //将子类的实例，赋值给父类的引用。就是向上转型
      //在向上转型的过程中会遗忘子类对象中与父类对象中不同的方法。也会覆盖与父类中相同的方法
      // 所以这里调用的因该是 A.show(A) 因为 B中的B.show(B)方法被丢弃，同时show(A)方法被重写
      // 因此就是 B to A
      System.out.println("a2.show(b);");

      
      a2.show(c);
      // 这里也和上面一样 由于向上转型 B.show(C)方法被丢弃了。
      System.out.println(" a2.show(c);");
      
      a2.show(d);
      // 调用 A.show(D)
      System.out.println("a2.show(d);");
      
      b.show(b);
      // 调用 B.show(B)
      System.out.println("b.show(b);");
      
      b.show(c);
      // 调用 C.show(C)      
      System.out.println("b.show(c)");
      
      b.show(d);
      // 调用 A.show(D)
      System.out.println("b.show(d);");


      OutClass outClass = new OutClass();
      
      OutClass.InnerClass innerclass = outClass.new InnerClass();
      innerclass.show();
    }
}