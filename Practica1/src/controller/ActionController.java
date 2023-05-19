package controller;

import controller.sd.exception.TopException;
import controller.sd.list.stack.Stack;
import model.Action;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author miguel
 */
public class ActionController {
    private Stack<Action> history;
    private Action action ;
    
    public ActionController () {
        this.history = new Stack<>(20);
    }
    
    public void register() throws TopException {
        
        history.push(action);
        action = null;
    }

    public Stack<Action> getHistory() {
        return history;
    }

    public void setHistory(Stack<Action> history) {
        this.history = history;
    }

    public Action getAction() {
        if (action == null) action = new Action();
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    
}
