/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.queue.MyQueue;
import controller.util.Util;
import javax.swing.table.AbstractTableModel;
import model.Request;

/**
 *
 * @author migue
 */
public class RequestTableModel extends AbstractTableModel {
    MyQueue<Request> data;
    
//    public RequestTableModel () {
////        data = new MyQueue<>(20);
//    }
    
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
            Request r = data.get(row);
                        
            if (column == 0) return r.getRequest();
            if (column == 1) return Util.getTime(r.getEnd());
        } catch (EmptyException | IndexException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "INFO";
        if (column == 1) return "END";
        
        return null;
    }

    public MyQueue<Request> getData() {
        return data;
    }

    public void setData(MyQueue<Request> data) {
        this.data = data;
    }
    
    
}
