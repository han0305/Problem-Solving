/* Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise. */

class MyQueue {

    /** Initialize your data structure here. */
    ArrayDeque<Integer> st1,st2;
    
    public MyQueue() {
        st1 = new ArrayDeque<Integer>();
        st2 = new ArrayDeque<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        st1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!st2.isEmpty()) {
            return st2.pop(); 
        }
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!st2.isEmpty()) {
            return st2.peek(); 
        }
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return st1.isEmpty() && st2.isEmpty();
    }
}