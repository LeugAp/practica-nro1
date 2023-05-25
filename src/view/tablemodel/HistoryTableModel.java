/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.stack.MyStack;
import controller.util.Util;
import javax.swing.table.AbstractTableModel;
import model.Action;

/**
 *
 * @author migue
 */
public class HistoryTableModel extends AbstractTableModel{

    MyStack<Action> data;
    
    public HistoryTableModel () {
        data = new MyStack<>(20);
    }
    
    @Override
    public int getRowCount() {
        return data.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        try {
            Action h = data.get(row);
                        
            if (column == 0) return h.getDescription();
            if (column == 1) return Util.getTime(h.getTime());
            
        } catch (EmptyException | IndexException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "INFO";
        if (column == 1) return "DATE";
        
        return null;
    }

    public MyStack<Action> getData() {
        return data;
    }

    public void setData(MyStack<Action> data) {
        this.data = data;
    }
    
    
}
