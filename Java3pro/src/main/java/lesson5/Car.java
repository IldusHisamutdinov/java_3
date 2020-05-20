package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch preparationCountDownLatch;
    private CountDownLatch allCarsCountDownLatch;
    private ReentrantLock winnerLock;
    private CyclicBarrier cyclicBarrier;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch preparationDownLatch, CyclicBarrier cyclicBarrier, ReentrantLock winnerLock, CountDownLatch allCarsCountDownLatch) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.preparationCountDownLatch = preparationDownLatch;
        this.cyclicBarrier = cyclicBarrier;
        this.winnerLock = winnerLock;
        this.allCarsCountDownLatch = allCarsCountDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            preparationCountDownLatch.countDown();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(winnerLock.tryLock()){
            System.out.println(this.name + "- WIN");
        }
        allCarsCountDownLatch.countDown();
    }
}
