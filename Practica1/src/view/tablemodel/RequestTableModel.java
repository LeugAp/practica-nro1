/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import controller.sd.list.queue.Queue;
import controller.util.Util;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Request;

/**
 *
 * @author migue
 */
public class RequestTableModel extends AbstractTableModel {
    Queue<Request> data;
    
    public RequestTableModel () {
        data = new Queue<>(20);
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
            Request r = data.get(row);
                        
            if (column == 0) return r.getRequest();
            if (column == 1) return Util.getTime(r.getEnd());
        } catch (EmptyException ex) {
            Logger.getLogger(RequestTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexException ex) {
            Logger.getLogger(RequestTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "Info";
        if (column == 1) return "End";
        
        return null;
    }

    public Queue<Request> getData() {
        return data;
    }

    public void setData(Queue<Request> data) {
        this.data = data;
    }
    
    
}
