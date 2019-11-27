package practice.thread;

// Java Program to illustrate the
// concept of interrupt() method
// while a thread does not stops working
class MyClass extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread executing");
                // Here current threads goes to sleeping state Another thread gets the chance to execute
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) { //interrupt has to e captured otherwise thread would not stop
            //interrupt only sets the interrupted flag to true, which can be used by java programmer later
            throw new RuntimeException("Thread interrupted");
        }
        System.out.println("we occur");
    }
}

public class InteruptThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyClass thread = new MyClass();
        thread.start();

        // main thread calls interrupt() method on
        // child thread
        thread.interrupt();
        Thread.sleep(1000);
        System.out.println("Main thread execution completes");
    }
}

