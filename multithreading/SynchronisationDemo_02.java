package multithreading;

import static java.io.IO.println;

public class SynchronisationDemo_02 {

     void main(){
        Account myAccount = new Account(100);
        myAccount.deposit(100);
        println("Current balance = "+myAccount.currentBalance());
//        try {
//            myAccount.withdraw(50);
//
//            myAccount.withdraw(50);
//
//            myAccount.withdraw(150);
//
//        } catch (InsufficientBalanceException e) {
//
//            println(e.toString());
//            println("current balance = "+myAccount.currentBalance());
//        }
        BackAccountThread object1 = new BackAccountThread(myAccount,"thread1");
        BackAccountThread object2 = new BackAccountThread(myAccount,"thread2");

        object1.thread.start();
        object2.thread.start();

    }
}

class InsufficientBalanceException extends Exception{
    String message;
    InsufficientBalanceException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "InsufficientBalanceException[" +
                "message='" + message + '\'' +
                ']';
    }
}
class Account {
    private int balance;

    Account(int balance){
        this.balance = balance;
    }

    public void deposit(int amount){
        this.balance += amount;
        println("Rs. "+amount+ " deosited sucessfully");
    }

    public int currentBalance(){
        //println("Current balance = "+this.balance);
        return this.balance;
    }
    public  void withdraw(int amount) throws InsufficientBalanceException {
        println(Thread.currentThread().getName() +" is trying to withdraw Rs. "+amount);
        if(this.balance-amount<0){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        else{
            //println(Thread.currentThread().getName() +" is executing........");
            println("Rs. "+amount+ " sucessfully withdrawn using " +Thread.currentThread().getName());
            this.balance -= amount;
            println("current balance = "+this.currentBalance());


        }
    }

}

class BackAccountThread implements Runnable {

    Account myAccount;
    Thread thread;

    BackAccountThread(Account myAccount,String name){
        this.myAccount = myAccount;
        thread = new Thread(this,name);
    }
    @Override
    public void run() {
        //println(Thread.currentThread().getName() +"is executing.........");
        try {
            myAccount.withdraw(150);
            //myAccount.withdraw(50);
            //myAccount.withdraw(150);


        } catch (InsufficientBalanceException e) {
            println(e.toString());
            println("current balance = "+myAccount.currentBalance());
        }
        //println(Thread.currentThread().getName() +"finished executing.........");
    }
}
