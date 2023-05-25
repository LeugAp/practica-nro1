
package model;

import controller.sd.list.MyLinkedList;

/**
 *
 * @author miguel
 */
public class Branch {
    private int id;
    private String name;
    private MyLinkedList<Sale> sales;
    
    public Branch () {
        this.sales = new MyLinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyLinkedList<Sale> getSales() {
        return sales;
    }

    public void setSales(MyLinkedList<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Branch{" + "id=" + id + ", name=" + name + ", sales=" + sales + '}';
    }
    
}
