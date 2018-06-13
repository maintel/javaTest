package thread;

/**
 * thread method wait test
 *
 * @author Maintel
 * @create 2018-06-14 1:05
 **/
public class WaitABCTest implements Runnable {

    private String name;
    private Object last;


    WaitABCTest(String name) {
        System.out.println(this);
        this.name = name;
    }


    public void setNext(Object last) {
        this.last = last;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (last) {
                System.out.println(last);
                synchronized (this) {
                        System.out.println(name);
                        this.notify();
                }
                try {
                    last.wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }
}
