package thread;

/**
 * Join Test
 *
 * @author Maintel
 * @create 2018-06-13 23:12
 **/
public class JoinTest2 extends Thread {

    private int sum;
    private JoinTest joinTest;

    JoinTest2() {
        joinTest = new JoinTest();
        joinTest.start();

    }

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("JoinTest2 sum::" + sum);
            if (i == 2) {
                // 这里加入了 join 意思是 JoinTest2 必须要等到 joinTest 线程执行完毕才会继续执行。
                try {
                    joinTest.join();
                } catch (InterruptedException e) {

                }
                // 这里等待 joinTest 的计算结果，然后加入到里面来
                sum = sum + joinTest.getSum();
            }

            try {
                sleep(800);
            } catch (InterruptedException e) {
            }

        }
    }
}
