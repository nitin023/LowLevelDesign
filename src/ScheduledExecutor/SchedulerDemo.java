package ScheduledExecutor;

public class SchedulerDemo {
    public static void main(String[] args) {
        DelayedScheduler delayedScheduler = new DelayedScheduler();
        delayedScheduler.schedule(()->System.out.println("five second delay task"), 5);
        delayedScheduler.schedule(()->System.out.println("one second delay task"), 1);
    }

}
