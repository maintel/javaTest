public class A{

  public static String TEST = "ADADADADAD";

  public A(){
    System.out.println("A 的构造函数");
  }

  public void printLn(){
    System.out.println("printLn");
  }

  public void show(D obj){
    System.out.println("A to D");
  }

  public void show(A obj){
    System.out.println("A to A");
  }

  public static void staticMethod(){
    System.out.println("staticMoth");
  }
}