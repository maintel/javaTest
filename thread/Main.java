package thread;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("main::" + Thread.currentThread());
//        TestThread testThreadA = new TestThread("A");
//        TestThread testThreadB = new TestThread("B");
//        testThreadA.run();
//        testThreadB.start();
        // 通过 runnable 达到了资源共享的目的。
        ThreadRunnable threadRunnable = new ThreadRunnable("C");
        new Thread(threadRunnable).start();
        new Thread(threadRunnable).start();
    }
}
