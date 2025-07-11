package multithreading;

import static java.io.IO.println;

public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();

        println("myThread ..."+Thread.currentThread().getName());
        try {
            for(int i =0;i<5;i++){
                println("My Thread:i*i="+i*i);
                Thread.sleep(500);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        println("child thread exiting");
    }

    void main(){

        println("Original thread "+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.run();
        //myThread.start();


        try {
            for(int i =5;i<10;i++){
                println("Main thread :i*i="+i*i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        println("thread exiting is " + Thread.currentThread().getName() );
    }
}
