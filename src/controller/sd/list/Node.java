
package controller.sd.list;

/**
 *
 * @author miguel
 */
public class Node<E> {
    private E info;
    private Node<E> next;

    public Node() {
    }

    public Node(E info) {
        this.info = info;
        this.next = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
