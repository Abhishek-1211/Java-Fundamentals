package multithreading;

import static java.io.IO.println;

public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        println("myThread ..."+Thread.currentThread().getName());
        for(int i =0;i<5;i++){
            println("child thread:i*i="+i*i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void main(){

        println("Original thread "+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        //myThread.run();
        myThread.start();


        for(int i =5;i<10;i++){
            println("Main thread :i*i="+i*i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //println("myThread thread"+Thread.currentThread().getName());
    }
}
