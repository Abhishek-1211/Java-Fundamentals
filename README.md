# Java-Fundamentals

## creating threads
### Extending Thread class
  * must override the run method and call start method to fork new thread fromm parent thread
  * Instead if you call run method instead of start() then no new thread is not created
  * Output of  when call myThread.run() from main method
    * ---------------------------No new Thread is created-----------------------------------------------
      * Original thread main
        myThread ...main
        child thread:i*i=0
        child thread:i*i=1
        child thread:i*i=4
        child thread:i*i=9
        child thread:i*i=16
        Main thread :i*i=25
        Main thread :i*i=36
        Main thread :i*i=49
        Main thread :i*i=64
        Main thread :i*i=81
      
  * Output for myThread.start()
    * -----------------------------New thread gets created---------------------------------------------
      * Original thread main
        myThread ...Thread-1
        child thread:i*i=0
        Main thread :i*i=25
        child thread:i*i=1
        Main thread :i*i=36
        Main thread :i*i=49
        child thread:i*i=4
        Main thread :i*i=64
        child thread:i*i=9
        Main thread :i*i=81
        child thread:i*i=16
      
### Implementing Runnable interface
