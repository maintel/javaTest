public class Palte<T>{
  private T item;
  public Palte(T t){
    item = t;
  }
  public void set(T t){item=t;}
  public T get(){return item;}
}