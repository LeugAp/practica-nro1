package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.list.MyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author migue
 * @param <T>
 */
public interface DaoInterface<T> {

    public void save(T obj) throws IOException;

    public void update(T obj, Integer index) throws IOException, EmptyException, IndexException;

    public MyLinkedList<T> getAll() throws FileNotFoundException;

    public T get(Integer id);
}
