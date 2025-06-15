package multithreading;

import static java.io.IO.println;

public class MultipleThreadsDemo implements Runnable {

    //String threadName;
    Thread myThread;

    MultipleThreadsDemo(String threadName){
        //this.threadName = threadName;
        myThread = new Thread(this, threadName);
        myThread.setName(threadName);
        //println("new Thread created..."+Thread.currentThread().getName());
    }

    public static void main(){

        MultipleThreadsDemo newThread1 = new MultipleThreadsDemo("One");
        MultipleThreadsDemo newThread2 = new MultipleThreadsDemo("Two");
        MultipleThreadsDemo newThread3 = new MultipleThreadsDemo("Three");
        println("main thread...");
        newThread1.myThread.start();
        newThread2.myThread.start();
        newThread3.myThread.start();
    }
    @Override
    public void run() {
        try {
           // println("new Thread created..."+);
            for(int i =0;i<5;i++){
                Thread.sleep(500);
                println("Thread "+Thread.currentThread().getName()+ " "+"i="+i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
