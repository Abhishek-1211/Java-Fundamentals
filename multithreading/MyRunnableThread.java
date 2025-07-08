package multithreading;

import static java.io.IO.println;

public class MyRunnableThread implements  Runnable {

    void main(){

        println("Original thread "+Thread.currentThread().getName());
        //MyThread myRunnableThread = new MyThread(new MyRunnableThread());
        Thread myRunnableThread = new Thread(new MyRunnableThread());
        myRunnableThread.start();


        try {
            for(int i =5;i<10;i++){
                println("Main thread :i*i="+i*i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        println("thread exiting is " + Thread.currentThread().getName() );
    }

    @Override
    public void run() {
        println("runnable Thread ..."+Thread.currentThread().getName());
        try {
            for(int i =0;i<5;i++){
                println("My Thread:i*i="+i*i);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        println("thread exiting is " + Thread.currentThread().getName() );
    }
}
