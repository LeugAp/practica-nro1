package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.stack.MyStack;
import java.io.IOException;

/**
 *
 * @author migue
 * @param <T>
 */
public interface DaoInterfaceStack<T> {

    public void save(T obj) throws TopException, IOException;

    public MyStack<T> getAll() throws IOException;

    public void update() throws IOException, EmptyException, IndexException;
}
