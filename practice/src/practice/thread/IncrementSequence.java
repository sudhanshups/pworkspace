package practice.thread;

class Number implements Runnable {
    static int i0 = 0;
    static int i1 = 1;
    static int i2 = 2;
    int thread = 0;

    @Override
    public synchronized void run() {
        while (true) {
            if(!String.valueOf(thread).equals(Thread.currentThread().getName())){
                try {
                    wait(1);
                    //System.out.println("waited" + Thread.currentThread().getName());
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            switch (Thread.currentThread().getName()) {
                case "0":
                    System.out.println(i0+ "  , thread:"+Thread.currentThread().getName());
                    if (i1 < i2) {
                        thread = 1;
                    } else {
                        thread = 2;
                    }
                    break;
                case "1":
                    System.out.println(i1+"  , thread:"+Thread.currentThread().getName());
                    i1 += 2;
                    thread = 0;
                    break;
                case "2":
                    System.out.println(i2+"  , thread:"+Thread.currentThread().getName());
                    i2 += 2;
                    thread = 0;
                    break;
            }
            notify();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i1>20)
                break;
        }
    }
}

public class IncrementSequence {
    public static void main(String[] args) throws InterruptedException {
        Number task = new Number();
        Thread zero = new Thread(task, "0");
        Thread odd = new Thread(task, "1");
        Thread even = new Thread(task, "2");
        zero.start();
        even.start();
        odd.start();

    }
}
