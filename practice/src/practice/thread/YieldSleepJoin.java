package practice.thread;/* 
29/07/19-1:02 AM
*/

// MyThread extending Thread
//https://www.geeksforgeeks.org/comparison-yield-join-sleep-java/
class SampleThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(Thread.currentThread().getName() + " in control (child thread)");
    }
}

public class YieldSleepJoin {
    public static void main(String[] args) throws InterruptedException {

        SampleThread t = new SampleThread();
        t.start();//child thread started

        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName() + " in control");
        }

        Thread.sleep(1000);

        System.out.println("== yield example ====");

        t  = new SampleThread();//child thread started
        t.start();
        System.out.println(t.getState());

        t.join();//child thread need to finish to proceed
        System.out.println("Joining child thread " + t.getName());
        System.out.println(t.getState());

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " in control");
        }

    }
}
