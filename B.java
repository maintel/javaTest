

public class B extends A{

  public B(){
    System.out.println(TEST);
    System.out.println("B 的构造函数");
  }

  public void show(B obj){
    System.out.println("B to B");
  }

  public void show(C obj){
    System.out.println("B to C");
  }

  public void print(){
    System.out.println("B println");
  }

  public void show(A obj){
    System.out.println("B to A");
  }

  public static void staticMethod(){
    System.out.println("staticMothBBB");
  }
}