/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.sd.list.stack;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.MyLinkedList;

/**
 *
 * @author miguel
 */
public class Pile<E> extends MyLinkedList<E> {

    private int top;

    public Pile(int top) {
        this.top = top;
    }

    public boolean isFull() {
        return (getSize() >= top );
    }

    public void push(E info) throws TopException {
        if (isFull()) throw new TopException();
        addFirst(info);
    }

    public E pop() throws EmptyException , IndexException {
        E data = null;
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            return this.delete(0);
        }
    }
    

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

}
