package thread;

/**
 * Join Test
 *
 * @author Maintel
 * @create 2018-06-13 23:12
 **/
public class JoinTest extends Thread {

    private int sum;
    private String name;


    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("JoinTest sum::" + sum);
            try {
                // 这里不能使用 wait
//                wait(1000);
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }

    }
}
