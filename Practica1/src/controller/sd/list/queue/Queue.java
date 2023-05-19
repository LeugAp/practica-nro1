/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controller.sd.list.queue;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;

/**
 *
 * @author miguel
 */
public class Queue<E> {
    private Queue1<E> queue;
    
    public Queue(int top) {
        queue = new Queue1(top);
    }
    
    public void queue(E obj) throws TopException {
        queue.queue(obj);
    }
    
    public E dequeue() throws EmptyException, IndexException {
        return queue.dequeue();
    }
    
    public E peek() {
        return queue.peek();
    }
    
    public  int getTop() {
        return queue.getTop();
    }
    
    public int getSize() {
        return queue.size();
    }
    
    public E get(int index) throws EmptyException, IndexException {
        return queue.get(index);
    }
    public void print() throws EmptyException {
        queue.print();
    }
}
