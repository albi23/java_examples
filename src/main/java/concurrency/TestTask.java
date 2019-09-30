package concurrency;

import java.util.concurrent.Callable;

public class TestTask implements Callable<Integer> {

    private static final int numberOfSquares = 10;
    private  final int maxMsSleepTime = 200;
    private int seedNumber;

    public TestTask(int number) {
        this.seedNumber = number;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= numberOfSquares; i++) {
            sum += Math.pow(seedNumber, i);
        }
//        System.out.println(Thread.currentThread().getName()); // to see concurrency
        return sum;
    }
}
