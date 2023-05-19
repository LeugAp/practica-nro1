/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.sd.exception.EmptyException;
import controller.sd.exception.IndexException;
import controller.sd.exception.TopException;
import controller.sd.list.queue.Queue;
import model.Request;

/**
 *
 * @author miguel
 */
public class RequestController {
    private Queue<Request> requests;
    private Request request;
    
    public RequestController () {
        this.requests = new Queue<>(20);
    }
    
    public void register() throws TopException{
        requests.queue(request);
        request = null;
    }
    
    public void update () throws EmptyException, IndexException {
        int result = requests.peek().getTime().compareTo(requests.peek().getEnd());
        if (result > 0) {
            requests.dequeue();
        }
        requests.print();
    }
    
    public Queue<Request> getRequests() {
        return requests;
    }

    public void setRequests(Queue<Request> requests) {
        this.requests = requests;
    }

    public Request getRequest() {
        if (request == null) request = new Request();
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    
}
