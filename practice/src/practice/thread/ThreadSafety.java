package practice.thread;

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {
    
        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        //wait for threads to finish processing
        //join() : When the join() method is called, the current thread will simply wait until the thread it is joining with is no longer alive.
        t1.join();
        t2.join();
        System.out.println("Processing count="+pt.getCount());
    }

}

class ProcessingThread implements Runnable{
    private int count;
    private Object lock = new Object();  // thread safety
    @Override
    public void run() {
        for(int i=1; i < 5; i++){
            processSomething(i);
            synchronized(lock){  // thread safety
            	count++;
            	System.out.println(this.toString() +" "+
                    	count +" "+Thread.currentThread().getName());
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}