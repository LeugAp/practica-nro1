/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import javax.swing.table.AbstractTableModel;
import model.Sale;

/**
 *
 * @author miguel
 */
public class SaleTableModel  extends AbstractTableModel {

    private MyLinkedList<Sale> data;

    public MyLinkedList<Sale> getData() {
        return data;
    }

    public void setData(MyLinkedList<Sale> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return data.getSize();
    }

    @Override
    public Object getValueAt(int row, int column) {
        try {
            Sale s = data.get(row);
            
            if (column == 0) return (s != null) ? s.getMonth().toString() : "Undefined";
            if (column == 1) return (s != null) ? s.getValue()            : "0.0";
            
        } catch (EmptyException | IndexException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {

        if (column == 0) return "MONTH";
        if (column == 1) return "VALUE";

        return null;
    }
}
