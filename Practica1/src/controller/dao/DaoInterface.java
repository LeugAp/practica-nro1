/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.dao;

import controller.sd.list.MyLinkedList;
import java.io.IOException;

/**
 *
 * @author migue
 */
public interface DaoInterface<T> {

    public void save(T obj) throws IOException;

    public void modify(T obj, Integer pos);

    public MyLinkedList<T> listing(); 

    public T get(Integer id);
}

