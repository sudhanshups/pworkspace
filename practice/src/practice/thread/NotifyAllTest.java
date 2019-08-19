package practice.thread;

// Java program to illustrate the behaviour of notify() method
//https://stackoverflow.com/questions/37026/java-notify-vs-notifyall-all-over-again
class Geek1 extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Geek1 " + Thread.currentThread().getName() + "...starts");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Geek1 " + Thread.currentThread().getName() + "...notified");
        }
    }
}

class Geek2 extends Thread {
    Geek1 geeks1;

    Geek2(Geek1 geeks1) {
        this.geeks1 = geeks1;
    }

    public void run() {
        synchronized (this.geeks1) {
            System.out.println("Geek2 " + Thread.currentThread().getName() + "...starts");

            try {
                this.geeks1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Geek2 " + Thread.currentThread().getName() + "...notified");
        }
    }
}

class Geek3 extends Thread {
    Geek1 geeks1;

    Geek3(Geek1 geeks1) {
        this.geeks1 = geeks1;
    }

    public void run() {
        synchronized (this.geeks1) {
            System.out.println("Geek3 " + Thread.currentThread().getName() + "...starts");
            //this.geeks1.notify();
            this.geeks1.notifyAll();
            System.out.println("Geek3 " + Thread.currentThread().getName() + "...notified");
        }
    }
}

public class NotifyAllTest {
    public static void main(String[] args) throws InterruptedException {

        Geek1 geeks1 = new Geek1();
        Geek2 geeks2 = new Geek2(geeks1);
        Geek3 geeks3 = new Geek3(geeks1);
        Thread t1 = new Thread(geeks1, "Thread-1");
        Thread t2 = new Thread(geeks2, "Thread-2");
        Thread t3 = new Thread(geeks3, "Thread-3");
        t1.start();
        t2.start();
        Thread.sleep(100);
        t3.start();
    }
}

