package thread;

public class TestThread extends Thread {


    private String name;

    TestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(currentThread());
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "::" + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
