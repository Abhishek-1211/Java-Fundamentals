# MultiThreading

* __What is a thread ?__
  * Thread is the fundamental unit of CPU execution.
    * At any moment of time, is CPU executing your program as a whole ? No, its exceuting only a portion/part of the program.
    * So, the sections/parts of program capable of being __executed independently__ is called _THREAD_

* __Why multithreading ?__
  * To maximise CPU utilisation

## Creating threads

### Extending Thread class

* must override the run method and call start method to fork new thread fromm parent thread
* Instead if you call run method instead of start() then no new thread is not created
* Output of  when call myThread.run() from main method
    * ---------------------------No new Thread is created-----------------------------------------------
        *![img_1.png](..%2Fassets%2Fimg_1.png)


* Output for myThread.start()
    * -----------------------------New thread gets created---------------------------------------------
      * ![img.png](..%2Fassets%2Fimg.png)


### Implementing Runnable interface (MyRunnableThread.java)

1. Create a class that implements _Runnable_
2. Override the _run()_ method - This contains code that will run in the thread
3. create a __Thread__ object, passing your runnable instance to the _Thread constructor_
4. Start the Thread using _thread.start()_

## Lifecycle of a Thread

## Methods to prevent thread execution
* yield()
* sleep()
* join()

## Synchronisation
* synchronised method
* synchronised block

## interthread communication

All the below run in synchronisation context

* __wait()__
  * runs within the synchronisation context
  * invoking thread releases the lock and goes into sleeping state unless some other thread 
    wakes it up by invoking notify() or  notifyAll()
  
* __notify()__
    When notify() is invoked by a thread it notifies one of the thread waiting on the object.
    The choice of which thread to notify depends on JVM
* __notifyAll()__