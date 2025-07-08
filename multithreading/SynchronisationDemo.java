package multithreading;

import static java.io.IO.print;
import static java.io.IO.println;

public class SynchronisationDemo {

    public void main() {

        CallMe callMe = new CallMe();

        String message1 = "Hello";
        String message2 = "Synchronised";
        String message3 = "World";

        Caller myCaller1 = new Caller(callMe,message1);
        Caller myCaller2 = new Caller(callMe,message2);
        Caller myCaller3 = new Caller(callMe,message3);


        myCaller1.myThread.start();
        myCaller2.myThread.start();
        myCaller3.myThread.start();
    }

}

class Caller implements Runnable {

    String msg;
    Thread myThread;
    CallMe callMe;

    Caller(CallMe callMe, String msg){
        this.msg = msg;
        myThread = new Thread(this);
        this.callMe = callMe;
    }

    @Override
    public void run() {
        callMe.call(msg);
    }
}

class CallMe {

       synchronized void call(String msg){
        print("["+msg);
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        println("]");
    }

    /*
    with synchronised keyword
    Output:[Hello][World][Synchronised]

    Without synchronisation
    Output1:[Synchronised[World[Hello]]]
    Output2: [Hello[Synchronised[World]]]

     */
}


