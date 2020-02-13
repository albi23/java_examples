package concurrency;

public class TestMultiThread {

    private short operations = 30;

    public static void main(String[] args) {
        new TestMultiThread().createAndRun();
//        for (Thread thread: threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void createAndRun() {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(() -> {
                while (getNumberOfOperation(false) > 0) {
                    test(getNumberOfOperation(true));
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
            System.out.println("Run : "+thread.getName());
        }
    }

    synchronized int getNumberOfOperation(boolean decrease) {
        if (!decrease) return operations--;
        return operations;
    }

    void test(int idTask) {
        System.out.println("Thread [" + Thread.currentThread().getName() + "][Priority : "+Thread.currentThread().getPriority()+"]  --> idTask : " + idTask);
        int tem = 0;
        for (int i = 0; i < 1000; i++) {
            tem += i;
            int y = i * i*i*i*i+111;
        }
        System.out.println("Thread [" + Thread.currentThread().getName() + " ]  result : " + tem);
    }
}
