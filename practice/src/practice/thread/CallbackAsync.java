package practice.thread;

// Java program to illustrate Asynchronous callback
interface OnGeekEventListener {

    // this can be any type of method
    void onGeekEvent();
}


class A implements OnGeekEventListener {

    @Override
    public void onGeekEvent() {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}

class B {

    private OnGeekEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener) {
        this.mListener = mListener;
    }

    // My Asynchronous task
    public void doGeekStuff() {

        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Performing operation in Asynchronous Task");                // perform any operation
                if (mListener != null) {  // check if listener is registered.
                    mListener.onGeekEvent();  // invoke the callback method of class A
                }
            }
        }).start();
    }

    // Driver Program
    public static void main(String[] args) {
        B obj = new B();
        OnGeekEventListener mListener = new A();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
        System.out.println("abd");

    }
}
