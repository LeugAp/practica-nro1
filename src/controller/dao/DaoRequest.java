
package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.queue.MyQueue;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Request;

/**
 *
 * @author migue
 */
public class DaoRequest extends DaoAdap<Request> implements DaoInterfaceQueue<Request> {

    public DaoRequest() {
        super(Request.class);
    }

    @Override
    public void save(Request obj) throws IOException, TopException {
        MyQueue<Request> queueRequestTmp = getAll();

        queueRequestTmp.queue(obj);

        saving(queueRequestTmp);
    }

    @Override
    public MyQueue<Request> getAll() throws IOException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        
        MyQueue<Request> queueActiontmp = (MyQueue<Request>) getConex().getXstream().fromXML(new FileReader(getUrl()));
                
        return queueActiontmp;
    }

    @Override
    public void update() throws IOException, EmptyException, IndexException {
        MyQueue<Request> queueRequestTmp = getAll();

        queueRequestTmp.dequeue();

        saving(queueRequestTmp);
    }

    private void saving(MyQueue<Request> listActions) throws IOException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        getConex().getXstream().toXML(listActions, new FileWriter(getUrl()));
    }

}
