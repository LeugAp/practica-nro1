package controller;

import controller.dao.DaoHistory;
import controller.dao.DaoRequest;
import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.queue.MyQueue;
import java.io.IOException;
import java.time.LocalDateTime;
import model.Request;

/**
 *
 * @author miguel
 */
public class RequestController {

    private DaoRequest dao;
    private ActionController history;
    private MyQueue<Request> requests;
    private Request request;

    public RequestController() {
        this.dao = new DaoRequest();
        this.history = new ActionController();
        loadQueue();
        try {
            update();
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void register() throws TopException, IOException {
        queue();
        
        historyAdd();
        loadQueue();
        request = null;
    }

    private void queue() throws IOException, TopException {
        dao.save(request);
    }
    private void historyAdd() throws TopException, IOException{
        
        history.getAction().setDescription("Added request");
        
        history.register();
    }

    private void dequeue() {
        try {
            dao.update();
        } catch (IOException | EmptyException | IndexException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadQueue() {
        try {
            setRequests(dao.getAll());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean update() throws EmptyException {

        boolean result = true;

        while (result) {

            if (requests.getSize() == 0) {
                return false;
            }

            result = LocalDateTime.now().isAfter(requests.peek().getEnd());

            if (!result) {
                break;
            }

            dequeue();

            loadQueue();
            System.out.println("a");
        }
        return true;
    }

    public MyQueue<Request> getRequests() {
        return requests;
    }

    public void setRequests(MyQueue<Request> requests) {
        this.requests = requests;
    }

    public Request getRequest() {
        if (request == null) {
            request = new Request();
        }
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
