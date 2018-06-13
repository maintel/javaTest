package thread;

/**
 * Join test thread A
 *
 * @author Maintel
 * @create 2018-06-13 23:48
 **/
public class JoinA implements Runnable {

    private int sum;
    private JoinB joinB;
    private Thread thread;

    JoinA() {
        joinB = new JoinB();
        thread = new Thread(joinB);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("JoinA sum::" + sum);
            if (i == 2) { // 模拟需要计算结果
                // 这里加入了 join 意思是 JoinTest2 必须要等到 joinTest 线程执行完毕才会继续执行。
                try {
                    thread.join();
                } catch (InterruptedException e) {

                }
                // 这里等待 joinTest 的计算结果，然后加入到里面来
                sum = sum + joinB.getSum();
            }
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
            }

        }
    }
}
