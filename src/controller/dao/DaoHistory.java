
package controller.dao;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.stack.MyStack;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Action;

/**
 *
 * @author migue
 */
public class DaoHistory extends DaoAdap<Action> implements DaoInterfaceStack<Action> {

    public DaoHistory() {
        super(Action.class);
    }

    @Override
    public void save(Action obj) throws TopException, IOException {
        MyStack stackActiontmp = getAll();
        
        stackActiontmp.push(obj);

        saving(stackActiontmp);
    }

    @Override
    public MyStack<Action> getAll() throws IOException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        MyStack stackActiontmp = (MyStack) getConex().getXstream().fromXML(new FileReader(getUrl()));

        return stackActiontmp;
    }

    @Override
    public void update() throws IOException, EmptyException, IndexException {
        MyStack stackActiontmp = getAll();

        stackActiontmp.pop();

        saving(stackActiontmp);
    }

    private void saving(MyStack<Action> listActions) throws IOException {
        getConex().getXstream().alias(getClas().getSimpleName().toLowerCase(), getClas());
        getConex().getXstream().toXML(listActions, new FileWriter(getUrl()));
    }

}
