package thread;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ThreadRunnable implements Runnable {

    private String name;
    private int total = 100;

    ThreadRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 一 这里使用 synchronized 来实现同步，
        synchronized (this) {
            while (total > 0) {
                System.out.println("ThreadRunnable-" + name + "::" + currentThread() + " total::" + total);
                total--;
                try {
//                    sleep(10); // sleep 不会释放锁 wait 会释放锁
                    // 使用 wait 让出 cpu 否则会一直持有 就和单线程没区别了 这里主要是为了模拟多线程的条件
                    wait(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(name + "::" + i);
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
