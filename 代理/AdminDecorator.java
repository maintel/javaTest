package 代理;

public class AdminDecorator implements IManager{

  private Admin admin;

  public AdminDecorator(Admin admin){
    super();
    this.admin = admin;
  }

  @Override
  public void doSome(){
    System.out.println("装饰器模式::==========");
    admin.doSome();
    System.out.println("装饰器模式::==========");
  }
}