/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.sd.list;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;

/**
 *
 * @author miguel
 */
public class MyLinkedList<E> {
    private Node<E> header;
    private Integer size = 0;

    public void add(E info) {
        Node<E> newNode = new Node<>(info);

        if (isEmpty()) {
            this.header = newNode;
        } else {
            Node<E> aux = this.header;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
        this.size++;
    }

    public void add(Integer index, E info) throws IndexException{
        if (index < 0 || index > getSize()) throw new IndexException();

        if (isEmpty()) {
            add(info);
        } else if (index == 0) {
            addFirst(info);
        } else {
            Node<E> newNode = new Node<>(info);
            Node<E> tmp = this.header;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            newNode.setNext(tmp.getNext());
            tmp.setNext(newNode);
            this.size++;
        }
    }

    public void addFirst(E info) {
        if (isEmpty()) {
            add(info);
        } else {
            Node<E> newNode = new Node<>(info);
            newNode.setNext(this.header);
            this.header = newNode;
            this.size++;
        }
    }

    public E get (Integer index) throws EmptyException, IndexException {
        if (isEmpty()) throw new EmptyException();
        if (index < 0 || index > getSize()) throw new IndexException();
        
        if (index == 0) return this.header.getInfo();

        Node<E> tmp = this.header;
        for (int i = 0 ; i < index ; i++) {
            tmp = tmp.getNext();
        }

        return tmp.getInfo();
    }
    
    public void modify (Integer index, E info) throws EmptyException, IndexException {
        if (isEmpty()) throw new EmptyException();
        if (index < 0 || index > getSize()) throw new IndexException();

        if (index == 0) {
             this.header.setInfo(info);
        } else {
            
             Node<E> tmp = this.header;
            for (int i = 0 ; i < index ; i++) {
                tmp = tmp.getNext();
            }
             tmp.setInfo(info);
        }
    }

    public void delete (Integer index) throws EmptyException, IndexException {
        if (isEmpty()) throw new EmptyException();
        if (index < 0 || index > getSize()) throw new IndexException();
        
        if (index == 0) {
            
            this.header = this.header.getNext();

        } else {

            Node<E> tmp = this.header;
            for (int i = 0 ; i < index ; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(tmp.getNext().getNext());

        }

        this.size--;
    }

    public void deleteAll () {
        this.header = null;
    }

    public boolean isEmpty() {
        return this.header == null;
    }

    public void print () throws EmptyException {
        if (this.header == null) throw new EmptyException();
        
        Node<E> tmp = this.header;

        System.out.print("List [");
        while (tmp != null) {
            System.out.print(" "+ tmp.getInfo() +", ");
            tmp = tmp.getNext();
        }
        System.out.print("]");

    }

    public Node<E> getHeader() {
        return this.header;
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}