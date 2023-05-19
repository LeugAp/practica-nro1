/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.dao;

import controller.sd.list.MyLinkedList;
import java.io.IOException;
import model.Branch;
import model.MonthEnum;
import model.Sale;

/**
 *
 * @author migue
 */
public class DaoBranch extends DaoAdap<Branch> {

    private Branch branch;

    public DaoBranch() {
        super(Branch.class);
    }

    public static void main(String[] args) throws IOException {
        DaoBranch dao = new DaoBranch();
        MyLinkedList<Branch> list = new MyLinkedList<>();
        
        Branch b = new Branch();
        b.setId(1);
        b.setName("Miguel");
        b.setSales(new MyLinkedList<>());

        for (MonthEnum m : MonthEnum.values()) {
            b.getSales().add(new Sale(m.ordinal(), m, 0.0));
        }
        list.add(b);
        dao.save(list);
        
        dao.listing();
    }
}
