
package controller;

import controller.dao.DaoHistory;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;

import controller.sd.list.stack.MyStack;
import java.io.IOException;
import model.Action;

/**
 *
 * @author miguel
 */
public class ActionController {

    private DaoHistory dao;
    private MyStack<Action> history;
    private Action action;

    public ActionController() {
        this.dao = new DaoHistory();
        loadHistory();
    }

    public void register() throws TopException, IOException {

        saveAction();

        loadHistory();

        action = null;
    }

    private void loadHistory() {
        try {
            setHistory(dao.getAll());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void saveAction() throws TopException, IOException {
        dao.save(action);
    }

    private void popAction() throws IOException, EmptyException, IndexException {
        dao.update();
    }

    public MyStack<Action> getHistory() {
        return history;
    }

    public void setHistory(MyStack<Action> history) {
        this.history = history;
    }

    public Action getAction() {
        if (action == null) {
            action = new Action();
        }
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
