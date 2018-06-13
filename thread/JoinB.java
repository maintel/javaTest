package thread;

/**
 * Join test thread B
 *
 * @author Maintel
 * @create 2018-06-13 23:48
 **/
public class JoinB implements Runnable {

    private int sum;

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("JoinB sum::" + sum);
            try {
                // 这里不能使用 wait 因为没有锁
//                wait(1000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
