package 代理;

public class AdminProxy implements IManager{

  private Admin admin;

  public AdminProxy(){
    super();
    this.admin = new Admin();
  }

  @Override
  public void doSome(){
    System.out.println("AdminProxy::==========");
    admin.doSome();
    System.out.println("AdminProxy::==========");
  }
}