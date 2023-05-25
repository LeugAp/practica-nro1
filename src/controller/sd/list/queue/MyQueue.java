
package controller.sd.list.queue;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguel
 */
public class MyQueue<E> {
    private Queue1<E> queue;
    
    public MyQueue(int top) {
        queue = new Queue1(top);
    }
    
    public void queue(E obj) throws TopException {
        queue.queue(obj);
    }
    
    public E dequeue() throws EmptyException, IndexException {
        return queue.dequeue();
    }
    
    public E peek() {
        try {
            return queue.peek();
        } catch (EmptyException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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
