package thread;

public class TestThread extends Thread {


    private String name;

    TestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(currentThread());
        for (int i = 0; i < 60; i++) {
            System.out.println(name + "::" + i);

            try {
                sleep(600);
            } catch (InterruptedException e) {
                return;
            }


            if (i == 30) {
                yield();
            }
        }
    }
}
