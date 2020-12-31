/* Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second(). */

class Foo {
    boolean firstExecuted,secondExecuted;
    public Foo() {
        firstExecuted = secondExecuted = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this) {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstExecuted = true;
        notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this) {
        while(!firstExecuted) 
            wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondExecuted = true;
        notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this) {
        while(!secondExecuted) 
            wait();  
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        }
    }
}