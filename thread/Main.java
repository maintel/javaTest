package thread;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("main::" + Thread.currentThread());
//        diaodu();
        // 通过 runnable 达到了资源共享的目的。
//        maipiao();

//        join();
//        yield();
//        stop();
        waitAbc();
    }

    private static void waitAbc() throws InterruptedException {
        WaitABCTest abcTestA = new WaitABCTest("A");
        WaitABCTest abcTestB = new WaitABCTest("B");
        WaitABCTest abcTestC = new WaitABCTest("C");
        abcTestA.setNext(abcTestC);
        abcTestB.setNext(abcTestA);
        abcTestC.setNext(abcTestB);
        new Thread(abcTestA).start();
        Thread.sleep(10);
        new Thread(abcTestB).start();
        Thread.sleep(10);
        new Thread(abcTestC).start();
    }

    private static void stop() {
        TestThread testThreadA = new TestThread("A");
        testThreadA.start();
        try {
            Thread.sleep(100);
            testThreadA.interrupt();
        } catch (InterruptedException e) {

        }
    }

    private static void yield() {
        TestThread testThreadA = new TestThread("A");
        TestThread testThreadB = new TestThread("B");
        testThreadA.start();
        testThreadB.start();
    }

    static void join() throws InterruptedException {
        new Thread(new JoinA()).start();
    }

    public static void diaodu() {
        TestThread testThreadA = new TestThread("A");
        TestThread testThreadB = new TestThread("B");
        TestThread testThreadC = new TestThread("C");
        TestThread testThreadD = new TestThread("D");
        TestThread testThreadE = new TestThread("D");
        testThreadC.setPriority(10);
        testThreadB.setPriority(3);
        testThreadD.setPriority(3);
        testThreadE.setPriority(3);
        testThreadA.setPriority(1);
        testThreadA.start();
        testThreadB.start();
        testThreadD.start();
        testThreadE.start();
        testThreadC.start();
    }

    public static void maipiao() {
        ThreadRunnable threadRunnable = new ThreadRunnable("C");
        new Thread(threadRunnable).start();
        new Thread(threadRunnable).start();
    }
}
