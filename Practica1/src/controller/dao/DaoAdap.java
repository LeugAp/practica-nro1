/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.list.MyLinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class DaoAdap<T> implements DaoInterface{
    private Conex conex;
    private Class clas;
    private String url;
    
    public DaoAdap (Class clas) {
        this.conex = new Conex();
        this.clas = clas;
        this.url = conex.URL+clas.getSimpleName().toLowerCase()+".json";
    }

    @Override
    public void save(Object obj) throws IOException {
        
        conex.getXstream().alias(clas.getSimpleName().toLowerCase(), clas);
        
        conex.getXstream().toXML(obj, new FileWriter(url));
        System.out.println("Json\n"+ conex.getXstream().toXML(obj));
    }

    @Override
    public void modify(Object obj, Integer pos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MyLinkedList<T> listing() {
        MyLinkedList<T> list = null;
        try {
            list =  (MyLinkedList<T>) this.conex.getXstream().fromXML(new FileReader(url));
            
            list.print();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoAdap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyException ex) {
            Logger.getLogger(DaoAdap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @Override
    public Object get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
