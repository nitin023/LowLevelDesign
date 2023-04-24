package ScheduledExecutor;

public class SchedulerDemo {
    public static void main(String[] args) {
        DelayedScheduler delayedScheduler = new DelayedScheduler();
        delayedScheduler.schedule(()->System.out.println("five second delay task"), 5);
        delayedScheduler.schedule(()->System.out.println("one second delay task"), 1);
        //Thread t1 = new Thread(()->delayedScheduler.schedule(()->System.out.println("five second delay task"), 5));
        //Thread t2 = new Thread(()->delayedScheduler.schedule(()->System.out.println("one second delay task"), 1));
        //t1.start();
        //t2.start();
    }

}
