/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.sd.list.stack;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;

/**
 *
 * @author miguel
 */
public class Stack<E> {
    private Pile<E> pile;
    
    public Stack(int top) {
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
}
