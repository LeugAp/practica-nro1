/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import controller.util.Util;
import javax.swing.table.AbstractTableModel;
import model.Branch;

/**
 *
 * @author miguel
 */
public class BranchTableModel extends AbstractTableModel{
    private MyLinkedList<Branch> data;

    public MyLinkedList<Branch> getData() {
        return this.data;
    }

    public void setData(MyLinkedList<Branch> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return data.getSize();
    }

    @Override
    public Object getValueAt(int row, int column) {
        try {
            
            Branch b = data.get(row);
            
            if (column == 0) return (b != null) ? b.getName()       : "Undefined";
            if (column == 1) return (b != null) ? Util.sumSales(b)  : "0.0";
            if (column == 2) return (b != null) ? Util.meanSales(b) : "0.0";
            
        } catch (EmptyException | IndexException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {

        if (column == 0) return "BRANCH";
        if (column == 1) return "ANNUAL SALE";
        if (column == 2) return "AVERAGE SALE";

        return null;
    }

}