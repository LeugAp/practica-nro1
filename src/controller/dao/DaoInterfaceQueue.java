
package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.queue.MyQueue;
import java.io.IOException;

/**
 *
 * @author migue
 * @param <T>
 */
public interface DaoInterfaceQueue<T> {

    public void save(T obj) throws IOException, TopException;

    public MyQueue<T> getAll() throws IOException;

    public void update() throws IOException, EmptyException, IndexException;
}
