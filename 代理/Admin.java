package 代理;

public class Admin implements IManager{

  @Override
  public void doSome(){
    System.out.println("Admin::doSome");
  }
}