
package controller.sd.list.stack;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;

/**
 *
 * @author miguel
 * @param <E>
 */
public class MyStack<E> {
    private Pile<E> pile;
    
    public MyStack(int top) {
        pile = new Pile<>(top);
    }
    
    public void push (E obj) throws TopException {
        pile.push(obj);
    }
    
    public E pop () throws EmptyException, IndexException {
        return pile.pop();
    }
    
    public void print () throws EmptyException{
        pile.print();
    }
    
    public int getTop () {
        return pile.getTop();
    }
    
    public int getSize() {
        return pile.getSize();
    }
    
    public E get (int index) throws EmptyException, IndexException {
        return pile.get(index);
    }
}
