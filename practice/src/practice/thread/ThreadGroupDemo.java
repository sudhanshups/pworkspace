package practice.thread;


class NewThread extends Thread {
    NewThread(String threadname, ThreadGroup tgob) {
        super(tgob, threadname);
        start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + " executing " + i);
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Exception encounterted");
            }
        }
    }
}

public class ThreadGroupDemo {

    public static void main(String arg[]) throws InterruptedException, SecurityException {

        ThreadGroup gfg = new ThreadGroup("Parent thread");        // creating the thread group
        ThreadGroup gfg_child = new ThreadGroup(gfg, "child thread");

        NewThread t1 = new NewThread("one", gfg);
        System.out.println("Starting one");

        NewThread t2 = new NewThread("two", gfg);
        System.out.println("Starting two");


        Thread[] group = new Thread[gfg.activeCount()]; // returns the number of threads put into the array
        int count = gfg.enumerate(group);
        //int count = gfg.enumerate(group, true); get all threads from child groups too

        for (int i = 0; i < count; i++) {
            System.out.println("Thread " + group[i].getName() + " found");
        }

        t1.join();        // block until other thread is finished
        t2.join();

        gfg_child.destroy();        // destroying child thread
        System.out.println(gfg_child.getName() + " destroyed");

        gfg.destroy();        // destroying parent thread
        System.out.println(gfg.getName() + " destroyed");

    }
}
