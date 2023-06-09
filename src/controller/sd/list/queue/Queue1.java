
package controller.sd.list.queue;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.MyLinkedList;

/**
 *
 * @author miguel
 */
public class Queue1<E> extends MyLinkedList<E>{
    private int top;
    
    public Queue1 (int tope) {
        this.top = tope;
    }
    
    public boolean isFull() {
        return (getSize() >= top);
    }
    
    public void queue(E data) throws TopException {
        if (isFull()) throw new TopException("Queue is full");
        
        this.add(data);
    }
    
    public E dequeue() throws EmptyException, IndexException {
        System.out.println("a");
        if (isEmpty()) throw new EmptyException("Queue Empty");
        
        return this.delete(0);
    }
    
    public E peek() throws EmptyException {
        if (isEmpty()) throw new EmptyException("Queue Empty");
        
        return getHeader().getInfo();
    }
    
    public int size() {
        return getSize();
    }
    
    public int getTop () {
        return this.top;
    }
}
